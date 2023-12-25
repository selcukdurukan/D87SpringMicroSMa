/**
 * Bu old file postgresql ve datajpa ile kullanılan entitydi biz bunu mongodb'ye çevirdik.
 * Biz bu entityleri önceden postgreSQL ve springDataJpa ile kullanıyorduk. Build.gradle dosyasından, bu 2 implementation
 * dosyasını kaldırdık ve yerine mongoDb implementation ekledik. Yapımızı aslında PostgreSQL'den mongoDB'ye geçirdik.
 */


/*package com.ba.boost.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntityOld {

    private Long createDate;
    private Long updateDate;

    *
     * Bir kayıt sadece silindiğinde pasife düşer, oluşturmuşsam aktiftir.
     * Aktiflik durumu kayıt var mı yok mu durumudur.
     * Veri tabanından hiç bir zaman data silinmez aktif data gerektiğinde pasife çekilir.
     * Pasife çekilen datalar başka bir veritabanında saklanabilir.

    private boolean isActive;

}*/
