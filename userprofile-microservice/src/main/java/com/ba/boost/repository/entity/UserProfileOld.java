/**
 * Bu old file postgresql ve datajpa ile kullanılan entitydi biz bunu mongodb'ye çevirdik.
 * Biz bu entityleri önceden postgreSQL ve springDataJpa ile kullanıyorduk. Build.gradle dosyasından, bu 2 implementation
 * dosyasını kaldırdık ve yerine mongoDb implementation ekledik. Yapımızı aslında PostgreSQL'den mongoDB'ye geçirdik.
 */

/*package com.ba.boost.repository.entity;

import com.ba.boost.utility.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "user_profiles")
public class UserProfileOld extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    /**
     * Auth microservicete kayıt olan bir kullanıcının id bilgisini tutar.
     *
     */
/*    private Long authId;
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

}*/
