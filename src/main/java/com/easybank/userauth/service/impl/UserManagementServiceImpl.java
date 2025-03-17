package com.easybank.userauth.service.impl;

import com.easybank.userauth.dto.UserDTO;
import com.easybank.userauth.service.IUserManagementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class UserManagementServiceImpl implements IUserManagementService {
    @Override
    public Optional<UserDTO> getUserById(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> getUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(Long userId, UserDTO userDTO) {

    }

    @Override
    public void deactivateUser(Long userId) {

    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return false;
    }

    @Override
    public boolean isEmailAvailable(String email) {
        return false;
    }
}
