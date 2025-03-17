package com.easybank.userauth.service.impl;

import com.easybank.userauth.dto.UserDTO;
import com.easybank.userauth.service.IUserAuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAuthServiceImpl implements IUserAuthService{


    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Optional<UserDTO> authenticateUser(String username, String password) {
        return Optional.empty();
    }

    @Override
    public void changePassword(Long userId, String oldPassword, String newPassword) {

    }

    @Override
    public void resetPassword(String email) {

    }

    @Override
    public boolean verifyEmail(String email, String verificationCode) {
        return false;
    }
}
