package com.ba.boost.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDto {

    @NotBlank(message = "Kullanıcı adı boş geçilemez.")
    @Size(min = 6, max = 32)
    private String username;
    @NotBlank(message = "Şifre boş geçilemez.")
    @Size(min = 8, max = 32)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!.,])(?=\\S+$).{8,32}$")
    private String password;
    @NotBlank(message = "Şifre boş geçilemez.")
    @Size(min = 8, max = 32)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^x&+=*!.,])(?=\\S+$).{8,32}$")
    private String rePassword;
    @Email(message = "Lütfen geçerli bir e-mail adresi giriniz.")
    private String email;
}
