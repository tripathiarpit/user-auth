package com.easybank.userauth.mapper;

import com.easybank.userauth.dto.RoleDTO;
import com.easybank.userauth.entity.Permission;
import com.easybank.userauth.entity.Roles;

import java.util.stream.Collectors;

public class RoleMapper {

    public static RoleDTO toDto(Roles role) {
        if (role == null) return null;
        RoleDTO dto = new RoleDTO();
       // dto.setId(role.getId());
      //  dto.setRoleName(role.getRoleName());
       // dto.setPermissionIds(role.getPermissions().stream()
         //       .map(Permission::getId)
         //       .collect(Collectors.toSet()));
        return dto;
    }

    public static Roles toEntity(RoleDTO dto) {
        if (dto == null) return null;
        Roles role = new Roles();
      //  role.setId(dto.getId());
      //  role.setRoleName(dto.getRoleName());
      //  role.setPermissions(dto.getPermissionIds().stream()
            //    .map(id -> {
            //        Permission p = new Permission();
           //         p.setId(id);
          //          return p;
//                .collect(Collectors.toSet()));
        return role;
    }
}
