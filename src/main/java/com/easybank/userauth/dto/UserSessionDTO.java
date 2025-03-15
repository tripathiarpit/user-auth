package com.easybank.userauth.dto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
@Getter
@Setter
public class UserSessionDTO {
    private Long id;
    private Long userId;
    private String sessionToken;
    private String ipAddress;
    private String userAgent;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}
