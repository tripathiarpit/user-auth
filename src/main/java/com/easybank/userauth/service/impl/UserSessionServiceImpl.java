package com.easybank.userauth.service.impl;

import com.easybank.userauth.entity.User;
import com.easybank.userauth.entity.UserSession;
import com.easybank.userauth.service.IUserSessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class UserSessionServiceImpl implements IUserSessionService {
    @Override
    public void logoutUser(String sessionToken) {

    }

    @Override
    public void invalidateAllSessions(Long userId) {

    }

    @Override
    public boolean isSessionValid(String sessionToken) {
        return false;
    }

    @Override
    public UserSession createSession(User user, String ipAddress, String userAgent) {
        return null;
    }

    @Override
    public Optional<UserSession> getSessionByToken(String sessionToken) {
        return Optional.empty();
    }

    @Override
    public void invalidateSession(String sessionToken) {

    }

    @Override
    public void invalidateUserSessions(User user) {

    }
}
