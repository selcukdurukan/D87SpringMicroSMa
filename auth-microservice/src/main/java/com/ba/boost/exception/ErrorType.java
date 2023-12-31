package com.ba.boost.exception;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_ERROR(5100, "Sunucuda beklenmeyen hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(4100, "Parametre eksik yada hatalı", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4110, "Kullanıcı adı veya şifre hatalı", HttpStatus.BAD_REQUEST),
    REGISTER_REPASSWORD_ERROR(4111, "Girilen şifreler uyuşmuyor", HttpStatus.BAD_REQUEST),
    REGISTER_KULLANICIADI_KAYITLI(4112, "Kullanıcı adı zaten kayıtlı", HttpStatus.BAD_REQUEST),
    JWT_TOKEN_CREATE_ERROR(4114, "Token oluşturma hatası", HttpStatus.BAD_REQUEST);


    int code;
    String message;
    HttpStatus httpStatus;


}
