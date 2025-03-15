package com.easybank.userauth.controller;

import com.easybank.userauth.service.IUserSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sessions")
public class UserSessionController {

    private final IUserSessionService userSessionService;

    public UserSessionController(IUserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logoutUser(@RequestParam String sessionToken) {
        userSessionService.logoutUser(sessionToken);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/invalidate-all")
    public ResponseEntity<Void> invalidateAllSessions(@PathVariable Long userId) {
        userSessionService.invalidateAllSessions(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> isSessionValid(@RequestParam String sessionToken) {
        return ResponseEntity.ok(userSessionService.isSessionValid(sessionToken));
    }
}

