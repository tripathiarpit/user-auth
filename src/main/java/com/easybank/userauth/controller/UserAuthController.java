package com.easybank.userauth.controller;

import com.easybank.userauth.dto.UserDTO;
import com.easybank.userauth.service.IUserAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    private final IUserAuthService userAuthService;

    public UserAuthController(IUserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userAuthService.registerUser(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Optional<UserDTO>> login(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(userAuthService.authenticateUser(username, password));
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestParam Long userId, @RequestParam String oldPassword, @RequestParam String newPassword) {
        userAuthService.changePassword(userId, oldPassword, newPassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@RequestParam String email) {
        userAuthService.resetPassword(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/verify-email")
    public ResponseEntity<Boolean> verifyEmail(@RequestParam String email, @RequestParam String verificationCode) {
        return ResponseEntity.ok(userAuthService.verifyEmail(email, verificationCode));
    }

}
