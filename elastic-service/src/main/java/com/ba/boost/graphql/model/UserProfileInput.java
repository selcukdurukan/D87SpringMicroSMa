package com.ba.boost.graphql.model;

import lombok.Data;

/**
 * Normalde elastic-service userprofile gibi alanları in-memory cachelemek için kullanılır.
 * biz burda graphql aracılığıyla input ekleyeceğiz ancak cachelenmiş yerlere veri eklenmez, sadece göstermek amacıyla
 * bu işi yapıyoruz.
 */
@Data
public class UserProfileInput {

    private Long authId;  //AuthService'in entity id'si
    private String username;
    private String profileImage;

}
