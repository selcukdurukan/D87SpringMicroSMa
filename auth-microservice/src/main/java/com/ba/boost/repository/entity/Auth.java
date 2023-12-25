package com.ba.boost.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "auts")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Long createDate;
    private Long updateDate;
    /**
     * Numara yapılarında, int değeri yada String değerini seçerken için kullanırız.
     */
    @Enumerated(EnumType.STRING)
    private State state;
}
