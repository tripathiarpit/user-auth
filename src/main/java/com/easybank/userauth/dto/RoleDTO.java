package com.easybank.userauth.dto;
import lombok.*;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class RoleDTO {
    private UUID id;
    private String roleName;
    private Set<UUID> permissionIds;

}
