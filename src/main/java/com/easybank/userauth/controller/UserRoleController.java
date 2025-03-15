package com.easybank.userauth.controller;

import com.easybank.userauth.dto.RoleDTO;
import com.easybank.userauth.service.IUserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final IUserRoleService userRoleService;

    public UserRoleController(IUserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping("/{userId}/assign")
    public ResponseEntity<Void> assignRoleToUser(@PathVariable Long userId, @RequestParam String roleName) {
        userRoleService.assignRoleToUser(userId, roleName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/remove")
    public ResponseEntity<Void> removeRoleFromUser(@PathVariable Long userId, @RequestParam String roleName) {
        userRoleService.removeRoleFromUser(userId, roleName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<RoleDTO>> getUserRoles(@PathVariable Long userId) {
        return ResponseEntity.ok(userRoleService.getUserRoles(userId));
    }
}
