/**
 * DtaJpa methodları artık çalışmaz çünkü implementation'ı kaldırdık ve yapıyı mongodb çevirdik.
 */

/*
package com.ba.boost.utility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

*/
/**
 *
 * @param <T> -> Bu sınıfı miras almak isteyen bir servis hangi entity'e hizmet ediyorsa onun type olarak verecek
 * @param <ID> -> Bu sınıfı miras alan servisin kullanmakta oldugu id tipini belirlemesi gerekir.
 *            (Long, String....)
 *//*

public class ServiceManagerOld<T extends BaseEntity, ID> implements IService<T, ID>{

    */
/**
     * Tüm servisler için ortak bir kullanım sunacak ise, burada repository üzerinden işlem yapılabiliyor olmalı.
     *//*

    private final JpaRepository<T, ID> repository;

    public ServiceManagerOld(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        t.setCreateDate(System.currentTimeMillis());
        t.setUpdateDate(System.currentTimeMillis());
        */
/**
         * Bir kayıt sadece silindiğinde pasife düşer, oluşturmuşsam aktiftir.
         * Aktiflik durumu kayıt var mı yok mu durumudur.
         * Veri tabanından hiç bir zaman data silinmez aktif data gerektiğinde pasife çekilir.
         * Pasife çekilen datalar başka bir veritabanında saklanabilir.
         *//*

        t.setActive(true);
        return repository.save(t);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> t) {
        t.forEach(p->{
            p.setActive(true);
            p.setCreateDate(System.currentTimeMillis());
            p.setUpdateDate(System.currentTimeMillis());
        });
        return repository.saveAll(t);
    }

    @Override
    public T update(T t) {
        t.setUpdateDate(System.currentTimeMillis());
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        t.setActive(false);
        repository.save(t);
    }

    @Override
    public void deleteByID(ID id) {
        Optional<T> t = repository.findById(id);
        if (t.isPresent()) {
            t.get().setActive(false);
            repository.save(t.get());
        }

    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findAllById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAllActive() {
        */
/**
         * Eğer veritabanında hiç kayıt yok ise ya da,
         * genellikle bigData, MongoDB gibi vt lerde
         * mevcut olmayan alanlarda(Refereance DataType) filtreleme yapıldığında NullPointException fırlatır.
         * Bunun önüne geçmek için en genel tanımı ile ilgili kaydın null olup olmadığını bakılır.
         *//*

        return repository.findAll().stream()
//                .filter(x-> x.isActive() != null)
                .filter(x-> x.isActive()
        ).collect(Collectors.toList());
    }

}
*/
