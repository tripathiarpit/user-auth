package com.easybank.userauth.mapper;

import com.easybank.userauth.dto.UserDTO;
import com.easybank.userauth.entity.Roles;
import com.easybank.userauth.entity.User;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO toDto(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
       // dto.setId(user.getId());
      //  dto.setEmail(user.getEmail());
//        dto.setRoleIds(user.getRoles().stream()
//                .map(Roles::getId)
//                .collect(Collectors.toSet()));
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
//        user.setId(dto.getId());
//        user.setEmail(dto.getEmail());
//        user.setRoles(dto.getRoleIds().stream()
//                .map(id -> {
//                    Roles r = new Roles();
//                    r.setId(id);
//                    return r;
//                })
//                .collect(Collectors.toSet()));
        return user;
    }
}
