package com.easybank.userauth.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "roles")
public class Roles {

    @Id
    @Column(name = "id", columnDefinition = "CHAR(36)")
    private String id;  // Using String instead of UUID

    @Column(name = "role_name", unique = true, nullable = false, length = 50)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;
}
