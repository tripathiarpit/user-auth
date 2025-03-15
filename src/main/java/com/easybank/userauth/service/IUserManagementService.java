package com.easybank.userauth.service;

import com.easybank.userauth.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserManagementService {
    Optional<UserDTO> getUserById(Long userId);
    Optional<UserDTO> getUserByUsername(String username);
    Optional<UserDTO> getUserByEmail(String email);
    List<UserDTO> getAllUsers();
    void updateUser(Long userId, UserDTO userDTO);
    void deactivateUser(Long userId);
    void deleteUser(Long userId);
    boolean isUsernameAvailable(String username);
    boolean isEmailAvailable(String email);
}
