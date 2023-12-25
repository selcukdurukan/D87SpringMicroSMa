package com.ba.boost.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoLoginRequestDto {

    @NotBlank(message = "Kullanıcı adı boş geçilemez.")
    @Size(min = 6, max = 32)
    private String username;
    @NotBlank(message = "Şifre boş geçilemez.")
    @Size(min = 8, max = 32)
    private String password;


}
