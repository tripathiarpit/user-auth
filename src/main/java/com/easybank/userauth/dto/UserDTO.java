package com.easybank.userauth.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.*;
@Getter
@Setter
@Schema(description = "DTO representing user details")
public class UserDTO {
    @Schema(name = "userId",description = "Id of the used", examples = "1")
    private Long id;
    @Schema(name="email",description = "User's email address", example = "john.doe@example.com")
    private String email;
    @Schema(
            description = "Set of role IDs assigned to the user",
            example = "[\"550e8400-e29b-41d4-a716-446655440000\", \"123e4567-e89b-12d3-a456-426614174000\"]"
    )
    private Set<UUID> roleIds;
}
