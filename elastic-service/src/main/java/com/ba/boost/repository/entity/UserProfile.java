package com.ba.boost.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "userprofile")
public class UserProfile {

    /**
     * Elasticsearch bir db gibi davranacağı için tuttuğu datalara id vermesi olasıdır.
     * ayrıca indexleme gibi işlemler içinde gereklidir.
     * bu nedenle isteğe bağlı olarak öncelik aldığınız db'nin id bilgisini kayıt edeviliginiz gibi bu işlemi elastic
     * search de yapabilir.
     */

    @Id
    private String id;
    private String userProfileId; //UserProfileService'in entity id'si
    private Long authId;  //AuthService'in entity id'si
    private String username;
    private String profileImage;

}
