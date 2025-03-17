package com.easybank.userauth.service.impl;

import com.easybank.userauth.dto.RoleDTO;
import com.easybank.userauth.service.IUserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserRoleServiceImpl implements IUserRoleService {

    @Override
    public void assignRoleToUser(Long userId, String roleName) {

    }

    @Override
    public void removeRoleFromUser(Long userId, String roleName) {

    }

    @Override
    public List<RoleDTO> getUserRoles(Long userId) {
        return null;
    }
}
