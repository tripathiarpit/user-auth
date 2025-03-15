package com.easybank.userauth.controller;

import com.easybank.userauth.dto.UserDTO;
import com.easybank.userauth.service.IUserManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserManagementController {

    private final IUserManagementService userManagementService;

    public UserManagementController(IUserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userManagementService.getUserById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<UserDTO>> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userManagementService.getUserByUsername(username));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<UserDTO>> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userManagementService.getUserByEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userManagementService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userManagementService.updateUser(id, userDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateUser(@PathVariable Long id) {
        userManagementService.deactivateUser(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userManagementService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/check-username")
    public ResponseEntity<Boolean> isUsernameAvailable(@RequestParam String username) {
        return ResponseEntity.ok(userManagementService.isUsernameAvailable(username));
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> isEmailAvailable(@RequestParam String email) {
        return ResponseEntity.ok(userManagementService.isEmailAvailable(email));
    }
}
