package com.easybank.userauth.dto;
import lombok.*;

import java.util.*;
import java.util.UUID;
@Getter
@Setter
public class PermissionDTO {
    private UUID id;
    private String permissionName;
}
