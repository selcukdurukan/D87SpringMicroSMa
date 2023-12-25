package com.ba.boost.utility;

import java.util.List;
import java.util.Optional;

/**
 * Servis sözleşmesi burada kalıp oluşturulan methodlar tüm servislerde aynıyla kullanılma zorundadır.
 * SORUNLAR;
 * 1 - Eğer buradai, methodlar tüm servisler tarafından kullanılacak ise, kaydetme işleminde hangi entity
 * adı yazılmazlı?
 * Çözüm: Type olarak belirsiz durumlarda, Object gibi katı parent türleri kullanmak yerine,
 * esnek bir şablon çıkartmak doğru olacaktır. Bunu yapabilmek için, GenericType ile çözülür.
 * 2 - Peki id her zaman long olmaz, String olabilir, Integer olabilir o zaman id için Long
 * kullanmak sorun yaratacaktır.
 */


public interface IService<T, ID> {

    T save(T t);
    Iterable<T> saveAll(Iterable<T> t);
    T update(T t);
    void delete(T t);
    void deleteByID(ID id);
    List<T> findAll();
    Optional<T> findAllById(ID id);
    List<T> findAllActive();

}
