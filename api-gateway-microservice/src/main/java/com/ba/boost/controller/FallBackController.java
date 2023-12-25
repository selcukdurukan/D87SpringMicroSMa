package com.ba.boost.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FallBackController {

    @GetMapping("/fallbackauth")
    public ResponseEntity<String> fallBackAuth() {
        return ResponseEntity.ok("AuthService doesn't work. Please try later...");
    }

    @GetMapping("/fallbackproduct")
    public ResponseEntity<String> fallBackProduct() {
        return ResponseEntity.ok("ProductService doesn't work. Please try later...");
    }

    @GetMapping("/fallbacksales")
    public ResponseEntity<String> fallBackSales() {
        return ResponseEntity.ok("SalesService doesn't work. Please try later...");
    }

    @GetMapping("/fallbackuser")
    public ResponseEntity<String> fallBackUser() {
        return ResponseEntity.ok("UserProfileService doesn't work. Please try later...");
    }
}
