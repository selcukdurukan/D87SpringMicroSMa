package com.ba.boost.service;

import com.ba.boost.repository.IProductRepository;
import com.ba.boost.repository.entity.Product;
import com.ba.boost.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product, Long> {

    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
