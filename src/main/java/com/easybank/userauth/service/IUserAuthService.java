package com.easybank.userauth.service;

import com.easybank.userauth.dto.UserDTO;

import java.util.Optional;

public interface IUserAuthService {
    UserDTO registerUser(UserDTO userDTO);
    Optional<UserDTO> authenticateUser(String username, String password);
    void changePassword(Long userId, String oldPassword, String newPassword);
    void resetPassword(String email);
    boolean verifyEmail(String email, String verificationCode);
}
