package com.ba.boost.controller;

import com.ba.boost.repository.entity.Role;
import com.ba.boost.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/saverole")
    public ResponseEntity<Void> saveRole(String roleName, Long authId) {
        roleService.save(Role.builder()
                .role(roleName)
                .authid(authId)
                .build());
        return ResponseEntity.ok().build();
    }
}
