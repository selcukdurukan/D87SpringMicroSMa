package com.ba.boost.controller;

import com.ba.boost.dto.request.DoLoginRequestDto;
import com.ba.boost.dto.request.RegisterRequestDto;
import com.ba.boost.dto.response.DoLoginResponseDto;
import com.ba.boost.dto.response.RegisterResponseDto;
import com.ba.boost.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.ba.boost.constants.RestApi.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Value("${buuygulama.birdeger}")
    private String buradaYMLdenBirDeğerAlalım;

    @Value("${buuygulama.yenibirdeger}")
    private String ymlAndEnvironmentVariable;


    /**
     * Bir endpoint'e istek atarken farklı yollarla parametre gönderilebilir.
     * 1- Header, başlık içinde
     * 2- Body, form elementi içinde (network kısmında payload'dan çek edebilrisin)
     * Burada body içinde parametreleri almak daha güvenlidir.
     *
     *  @Valid -> girilen bilgilerin belli kriterleri olmalıdır. Mesela şifrenin karmaşıklığı veya
     *  email adresinin doğru formatta olması v.s.
     *
     * @param dto
     * @return
     */
//    @PostMapping(DOLOGIN)
//    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequestDto dto) {
//        return ResponseEntity.ok(authService.doLogin(dto));
//    }

    @PostMapping(DOLOGIN)
    @CrossOrigin("*")
    public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto) {
        return ResponseEntity.ok(DoLoginResponseDto.builder()
                        .token(authService.doLogin(dto))
                .build());
    }

    @PostMapping(REGISTER)
    @CrossOrigin("*")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) {
        System.out.println("YML'den gelen değer......: " + buradaYMLdenBirDeğerAlalım);
        System.out.println("YML ve System environmenttan gelen....: " + ymlAndEnvironmentVariable);
        return ResponseEntity.ok(authService.save(dto));
    }


    @GetMapping("/say")
//    @PreAuthorize("hasAuthority('SELAM_ABI_GECIYORDUM_UGRADIM') or hasAuthority('ADMIN')")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hi, I'm Auth Service");
    }

    @GetMapping("/sayadmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> sayHelloAdmin() {
        return ResponseEntity.ok("Hi, I'm Auth Admin auth Service");
    }


}
