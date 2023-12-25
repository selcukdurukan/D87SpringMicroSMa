package com.ba.boost.service;

import com.ba.boost.repository.IRoleRepository;
import com.ba.boost.repository.entity.Role;
import com.ba.boost.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends ServiceManager<Role, Long> {

    private final IRoleRepository repository;

    public RoleService(IRoleRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Role> findByAuthid(Long authid){
        return repository.findByAuthid(authid);
    }
}
