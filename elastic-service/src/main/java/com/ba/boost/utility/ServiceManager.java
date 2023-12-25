/**
 * Old dosyada yazan JpaRepository<T, ID> yerine MongoRepository<T, ID> yazıldı.
 */

package com.ba.boost.utility;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 *
 * @param <T> -> Bu sınıfı miras almak isteyen bir servis hangi entity'e hizmet ediyorsa onun type olarak verecek
 * @param <ID> -> Bu sınıfı miras alan servisin kullanmakta oldugu id tipini belirlemesi gerekir.
 *            (Long, String....)
 */
public class ServiceManager<T, ID> implements IService<T, ID>{

    /**
     * Tüm servisler için ortak bir kullanım sunacak ise, burada repository üzerinden işlem yapılabiliyor olmalı.
     */
    private final ElasticsearchRepository<T, ID> repository;

    public ServiceManager(ElasticsearchRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> t) {
        return repository.saveAll(t);
    }

    @Override
    public T update(T t) {
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.save(t);
    }

    @Override
    public void deleteByID(ID id) {
        Optional<T> t = repository.findById(id);
        if (t.isPresent()) {
            repository.save(t.get());
        }

    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findAllById(ID id) {
        return repository.findById(id);
    }


}
