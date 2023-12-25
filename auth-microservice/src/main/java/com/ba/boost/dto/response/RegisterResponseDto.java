package com.ba.boost.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseDto {

    private Long authId;
    private String content;
    private String email;
    /**
     * 100 - kayıt başarılı
     * 200 - kayıt beklemede
     * 300 - hata
     * 400 - parametre hataları
     */
    private Integer registerState;

}
