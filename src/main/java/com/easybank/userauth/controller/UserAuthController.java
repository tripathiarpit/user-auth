package com.easybank.userauth.controller;

import com.easybank.userauth.dto.ErrorResponseDto;
import com.easybank.userauth.dto.UserDTO;
import com.easybank.userauth.entity.UserSession;
import com.easybank.userauth.service.IUserAuthService;
import com.easybank.userauth.service.IUserManagementService;
import com.easybank.userauth.service.IUserSessionService;
import com.easybank.userauth.util.LoginUtilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    private final IUserAuthService userAuthService;
    private final IUserSessionService userSessionService;
    private final IUserManagementService userManagementService;

    private LoginUtilService loginUtil;

    public UserAuthController(IUserAuthService userAuthService,
                              IUserSessionService userSessionService,
                              IUserManagementService userManagementService, LoginUtilService loginUtil) {
        this.userAuthService = userAuthService;
        this.userSessionService = userSessionService;
        this.userManagementService = userManagementService;
        this.loginUtil = loginUtil;
    }
    @Operation(
            summary = "Register User REST API",
            description = "REST API to create new User",
            requestBody= @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true,
                    description = "User Object for registration",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation =UserDTO.class )))
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userAuthService.registerUser(userDTO));
    }

    @Operation(summary = "API to login User",description = "REST API Login User")
    @ApiResponse(
            responseCode = "200",
            description = "Login successful",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = UserDTO.class),
                    examples = @ExampleObject(
                            name = "Successful Login",
                            value = """
                {
                    "token": "eyJhbGciOiJIUzI1NiIsInR...",
                    "expiresIn": 3600
                }
                """
                    )
            )
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized - Invalid credentials",
            content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            )
    )
    @PostMapping("/login")
    public ResponseEntity<UserSession> login(@RequestParam @Parameter(
            description = "UserName of Customer",
            example = "rakesh"
    )String username, @RequestParam @Parameter(
            description = "Account password of Customer"
    ) String password, HttpServletRequest request) throws Exception {
        return ResponseEntity.ok(loginUtil.login(username, password, request.getRemoteAddr()));
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
