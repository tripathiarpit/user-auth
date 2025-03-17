package com.easybank.userauth.service;

import com.easybank.userauth.entity.User;
import com.easybank.userauth.entity.UserSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IUserSessionService {
    void logoutUser(String sessionToken);
    void invalidateAllSessions(Long userId);
    boolean isSessionValid(String sessionToken);

    UserSession createSession(User user, String ipAddress, String userAgent);

    Optional<UserSession> getSessionByToken(String sessionToken);

    void invalidateSession(String sessionToken);

    void invalidateUserSessions(User user);
}
