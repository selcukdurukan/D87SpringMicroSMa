package com.ba.boost.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {

    /**
     * Normal kullanımı system_envionrementta tutmak fakat biz burada ögrenmek için normal yazıyoruz.
     */
//    @Value("${SECRET_KEY}")
//    String secretKey;
    private String password = "1234";
    /**
     * Login olan kişinin Id bilgisini alarak ana yeni bir token üretmek için kullanılır.
     * @param id
     * @return
     */
    public Optional<String> createToken(Long id){
        String token;
        Long exDate = 1000L*60*15;
        try {
            /**
             *  DIKKAT!!! Kullanıcı adı şifre claim içine koyulmaz.
             *  Claim nesnesi olarak yerleştirdiğiniz bilgilerin açık okunur olduğunu asla unutmayınız.
             */
           token = JWT.create()
                    .withAudience()
                    .withClaim("id",id) //Token içerisine eklemek istediginiz nesneleri bununla ekliyoruz.
                    .withClaim("howtopage", "auth-microservice")
                    .withClaim("isOne", true)
                    .withIssuer("authservice") //sahbi
                    .withIssuedAt(new Date())  //oluşturulma zamanı
                    .withExpiresAt(new Date(System.currentTimeMillis() + exDate)) //geçersiz olma zamanı
                    .sign(Algorithm.HMAC512(password));
            return Optional.of(token);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Kullanıcı tarafından verilen token bilgisinin doğruluğunu kontrol etmek için kullanırılız.
     * Token imzası ve geçerliliği kontrol edilir.
     * @param token
     * @return
     */
    public Boolean validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC512("1234");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("authservice")
                    .build();
           DecodedJWT decodedJWT = verifier.verify(token);
           if (decodedJWT == null)
               return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Token bilgisi gönderen kullanıcının id bilgisi token payload içinden alınır.
     * @param token
     * @return
     */
    public Optional<Long> getByIdFromToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC512("1234");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("authservice")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if (decodedJWT == null)
                return Optional.empty();
            return Optional.of(decodedJWT.getClaim("id").asLong());
        } catch (Exception e) {
            return Optional.empty();
        }
    }


}
