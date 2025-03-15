package com.easybank.userauth.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
public class User extends BaseEntity{
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Long customerId;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash",nullable = false)
    private String password_hash;

    @Column(name = "is_active",nullable = false)
    private Boolean isActive;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles;
}
