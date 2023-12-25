package com.ba.boost.repository.entity;

import com.ba.boost.utility.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public class UserProfile extends BaseEntity {

    /**
     * Long -> String çünkü mongoda long kullanılmaz..
     */
    @Id
    private String id;

    /**
     * Auth microservicete kayıt olan bir kullanıcının id bilgisini tutar.
     *
     */
    private Long authId;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String profileImage;
    private String avatar;
    private String info;
    private String facebook;
    private String twitter;
    private String instagram;




}
