package com.ba.boost.service;

import com.ba.boost.repository.ISaleRepository;
import com.ba.boost.repository.entity.Sale;
import com.ba.boost.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SaleService extends ServiceManager<Sale, Long> {

    private final ISaleRepository repository;

    public SaleService(ISaleRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
