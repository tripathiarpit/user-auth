package com.easybank.userauth.service;
import com.easybank.userauth.dto.RoleDTO;

import java.util.List;

public interface IUserRoleService {
    void assignRoleToUser(Long userId, String roleName);
    void removeRoleFromUser(Long userId, String roleName);
    List<RoleDTO> getUserRoles(Long userId);
}
