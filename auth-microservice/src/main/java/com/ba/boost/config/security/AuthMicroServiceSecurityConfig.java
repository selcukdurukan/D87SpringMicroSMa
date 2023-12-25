package com.ba.boost.config.security;

import com.sun.xml.bind.v2.TODO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthMicroServiceSecurityConfig {

    @Bean
    JwtTokenFilter getJwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        /**
         * _csrf kapatma ve açma işlemlerinde kullanılır.Csrf sisteminizin güvende kalmasını sağlamak için kullanılır.
         * _csrf bir keydir o keyi spring yaratıp yaratmadığı kontrol edilir ve giriş sağlanır. Bu key aynı zamanda
         * milyonlarca request atılmasının önüne geçer.
         */
        httpSecurity.csrf().disable();

        /**
         * Öncelikle gelen tüm isteklere doğrulama uygulayacağımızı bildiriyoruz.
         * antMatchers -> izin verilecek ya da verilmeyecek endpointlerin belirlendiği alandır.
         * permitAll -> gelen tüm isteklere izin ver.
         * anyRequest -> herhangi bir istek
         * authenticated -> oturum açmaya tabi tut. Kimlik doğrulama yap.
         */
//        httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.authorizeRequests()
                .antMatchers("/v3/api-docs/**",
                        "/swagger-ui/**", "/v1/dev/auth/dologin"
                        , "/role/**", "/v1/dev/auth/register")
                .permitAll()
                .anyRequest()
                .authenticated();

        /**
         * Bir filtre uygulanacak bunun nasıl yapılacağı ve hangi şekilde yapılacağının belirtilmesine ihtiyaç vardır.
         * Bunun parametrelerini yazacağız.
         * 1-Filter nesnesi
         * 2-Filter type class
         */
        httpSecurity.addFilterBefore(getJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        /**
         * Gelen isteklere oturum açma zorunluluğu getirildikten sonra bir login page'e yönlendirilme yapmak gereklidir.
         * Bunun aktif edilmesi ağağıdaki şekilde olur. Ayrıca kendinize ait bir Login Page kullanmak isterseniz,
         * sayfanın uzantısını buraya girmeniz gereklidir.
         */
//        httpSecurity.formLogin();
        return httpSecurity.build();
    }


}
