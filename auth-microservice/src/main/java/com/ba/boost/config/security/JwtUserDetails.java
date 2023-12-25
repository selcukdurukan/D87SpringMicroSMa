package com.ba.boost.config.security;

import com.ba.boost.repository.entity.Auth;
import com.ba.boost.service.AuthService;
import com.ba.boost.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    AuthService authService;

    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails getUserByAuthId(Long authId) {
        Optional<Auth> auth = authService.findAllById(authId);
        if (auth.isEmpty()) {
            return null;
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        /**
         * Burada belirtilen isimlendirmeler tamamen size aittir. Özel bir kullanım değildir.
         * Yetki adı: Yönetici, asistan,
         */
//        authorities.add(new SimpleGrantedAuthority("USER"));
//        authorities.add(new SimpleGrantedAuthority("EDITOR"));
//        authorities.add(new SimpleGrantedAuthority("SELAM_ABI_GECIYORDUM_UGRADIM"));

        roleService.findByAuthid(authId).forEach(x->{
            authorities.add(new SimpleGrantedAuthority(x.getRole()));
        });
        return User.builder()
                .username(auth.toString())
                .password("")
                .accountLocked(false)
                .accountExpired(false)
                .authorities(authorities)
                .build();
    }
}
