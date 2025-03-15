package com.easybank.userauth.dto;
import lombok.*;

import java.util.*;
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private Set<UUID> roleIds;
}
