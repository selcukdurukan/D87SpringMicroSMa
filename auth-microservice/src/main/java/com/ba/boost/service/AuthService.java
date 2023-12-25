package com.ba.boost.service;

import com.ba.boost.dto.request.CreateProfileRequestDto;
import com.ba.boost.dto.request.DoLoginRequestDto;
import com.ba.boost.dto.request.RegisterRequestDto;
import com.ba.boost.dto.response.RegisterResponseDto;
import com.ba.boost.exception.AuthMicroserviceException;
import com.ba.boost.exception.ErrorType;
import com.ba.boost.manager.IUserProfileManager;
import com.ba.boost.mapper.IAuthMapper;
import com.ba.boost.rabbitmq.model.CreateUser;
import com.ba.boost.rabbitmq.producer.CreateUserProducer;
import com.ba.boost.repository.IAuthRepository;
import com.ba.boost.repository.entity.Auth;
import com.ba.boost.utility.JwtTokenManager;
import com.ba.boost.utility.ServiceManager;
import com.ba.boost.utility.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository repository;

    /**
     * DİKKAT!!!
     * Kullanmak istediğiniz interface, services, component gibi sınıflardan nesne türetmek için 2 yolunuz var.
     *
     * @Autowired ile işaretlemek ya da Constructor Injection ile kullanmak.
     */

//    @Autowired
//    private IUserProfileManager iUserProfileManager;
    private final IUserProfileManager iUserProfileManager;

//    private final TokenGenerator tokenGenerator;

    private final JwtTokenManager jwtTokenManager;

    private final CreateUserProducer createUserProducer;

    public AuthService(IAuthRepository repository, IUserProfileManager iUserProfileManager,
                       JwtTokenManager jwtTokenManager, CreateUserProducer createUserProducer) {
        super(repository);
        this.repository = repository;
        this.iUserProfileManager = iUserProfileManager;
        this.jwtTokenManager = jwtTokenManager;
        this.createUserProducer = createUserProducer;
    }

    /**
     * DİKKAT! bu save method'u ServiceManager methodunun overload edilmiş halidir.
     * DTO ile işlem yapar.
     *
     * @param dto
     * @return
     */
    public RegisterResponseDto save(RegisterRequestDto dto) {

        /**
         * Eğer şifre ile ikinci şifre uyuşmuyor ise direkt, false dönülmesi mantıklıdır.
         */
        if (!dto.getPassword().equals(dto.getRePassword()))
/*            return RegisterResponseDto.builder()
                    .registerState(300)
                    .content("Girmiş olduğunuz şifreler uyuşmamaktadır.")
                    .build();*/
            throw new AuthMicroserviceException(ErrorType.REGISTER_REPASSWORD_ERROR);

        /**
         * Burada elle dönüşüm yerine mapper kullanmak daha doğru olacaktır.
         */

        /**
         * Elle dönüşüm
         */
/*        save(
                Auth.builder()
                        .username(dto.getUsername())
                        .password(dto.getPassword())
                        .email(dto.getEmail())

                        .build()
        );*/
        if (repository.findOptionalByUsername(dto.getUsername()).isPresent())
            throw new AuthMicroserviceException(ErrorType.REGISTER_KULLANICIADI_KAYITLI);

        Auth auth = save(IAuthMapper.INSTANCE.toRegisterRequestDto(dto));

        /**
         * Artık aşagıda feign kullanmak yerine rabbitMq kullanarak userserivece gönderiyoruz
         */
//        iUserProfileManager.createProfile(CreateProfileRequestDto.builder()
//                .token("")
//                .authId(auth.getId())
//                .username(auth.getUsername())
//                .email(auth.getEmail())
//                .build());

        createUserProducer.convertAndSendMessageCreateUser(CreateUser.builder()
                        .authId(auth.getId())
                        .username(auth.getUsername())
                        .email(auth.getEmail())
                .build());

        RegisterResponseDto result = IAuthMapper.INSTANCE.fromAuth(auth);
        result.setRegisterState(100);
        result.setContent(auth.getEmail() + " ile başarılı şekilde kayıt oldunuz.");
        return result;

/*        return RegisterResponseDto.builder()
                .email(auth.getEmail())
                .registerState(100)
                .content(auth.getEmail() + "ile başarılı şekilde kayıt oldunuz.")
                .authId(auth.getId())
                .build();*/
    }

    public String doLogin(DoLoginRequestDto dto) {
        Optional<Auth> auth = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (auth.isEmpty())
            throw new AuthMicroserviceException(ErrorType.LOGIN_ERROR);
        /**
         * Login olan kişiler için özel bir token üretmek mantıklıdır.
         */
        Optional<String> token =  jwtTokenManager.createToken(auth.get().getId());
        if (token.isEmpty())
            throw new AuthMicroserviceException(ErrorType.JWT_TOKEN_CREATE_ERROR);
        return token.get();
    }


}
