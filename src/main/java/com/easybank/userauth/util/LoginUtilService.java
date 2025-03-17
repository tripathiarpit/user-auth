package com.easybank.userauth.util;

import com.easybank.userauth.dto.UserDTO;
import com.easybank.userauth.entity.User;
import com.easybank.userauth.entity.UserSession;
import com.easybank.userauth.mapper.UserMapper;
import com.easybank.userauth.service.IUserAuthService;
import com.easybank.userauth.service.IUserManagementService;
import com.easybank.userauth.service.IUserSessionService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class LoginUtilService {

    private final IUserAuthService userAuthService;
    private final IUserSessionService userSessionService;
    private final IUserManagementService userManagementService;

    private LoginUtilService loginUtil;

    public LoginUtilService(IUserAuthService userAuthService,
                              IUserSessionService userSessionService,
                              IUserManagementService userManagementService) {
        this.userAuthService = userAuthService;
        this.userSessionService = userSessionService;
        this.userManagementService = userManagementService;
    }
    public UserSession login(String username, String password, String ipAddress) throws Exception{
        Optional<UserDTO> currentUser = userAuthService.authenticateUser(username, password);
        if(!currentUser.isEmpty()) {
            Optional<UserDTO> s = userManagementService.getUserByUsername(username);
            User newUser =   UserMapper.toEntity(s.get());
            return userSessionService.createSession(newUser, ipAddress,"browser");
        }
        throw new Exception("Not allowed to login");
    }
}
