package com.easybank.userauth.entity;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Permission {

    @Id
    @Column(name = "id", columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "permission_name", unique = true, nullable = false, length = 50)
    private String permissionName;

    @ManyToMany(mappedBy = "permissions")
    private Set<Roles> roles;
}
