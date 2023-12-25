package com.ba.boost.utility;

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
public class BaseEntity {

    private Long createDate;
    private Long updateDate;

    /**
     * Bir kayıt sadece silindiğinde pasife düşer, oluşturmuşsam aktiftir.
     * Aktiflik durumu kayıt var mı yok mu durumudur.
     * Veri tabanından hiç bir zaman data silinmez aktif data gerektiğinde pasife çekilir.
     * Pasife çekilen datalar başka bir veritabanında saklanabilir.
     */
    private boolean isActive;

}
