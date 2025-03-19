package com.easybank.userauth.mapper;

import com.easybank.userauth.dto.PermissionDTO;
import com.easybank.userauth.entity.Permission;

public class PermissionMapper {

    public static PermissionDTO toDto(Permission permission) {
        if (permission == null) return null;
        PermissionDTO dto = new PermissionDTO();
      //  dto.setId(permission.getId());
        //dto.setPermissionName(permission.getPermissionName());
        return dto;
    }

    public static Permission toEntity(PermissionDTO dto) {
        if (dto == null) return null;
        Permission permission = new Permission();
        //permission.setId(dto.getId());
       // permission.setPermissionName(dto.getPermissionName());
        return permission;
    }
}
