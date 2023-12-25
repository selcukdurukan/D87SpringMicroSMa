package com.ba.boost.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseRequestDto {

    @NotBlank
//    @Size(min = 5, max = 35, message = "5-32 karakter arası girilmeli")
    private String token;
    /**
     * Geçerli sayfa numarası
     */
    Integer currentPage;
    /**
     * Bir sayfada gösterilecek kayıt sayısı
     */
    Integer pageSize;
    /**
     * Sıralama yapılacak sutunadı
     */
    String sortParameter;
    /**
     * sıralamanın yönü, ASC, DESC
     */
    String direction;
}
