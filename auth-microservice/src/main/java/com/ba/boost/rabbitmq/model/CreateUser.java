package com.ba.boost.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/**
 * DİKKAT!
 * 1-Bu sınıfı mutlaka serileştirilmelidir.
 * 2-Mutlaka bu sınıfın paket adı ve tanımlamalarını karşılayan consumer aynı yapılandırmayı kullanmalıdır.
 */
public class CreateUser implements Serializable {


    private Long authId;
    private String username;
    private String email;

}
