package com.easybank.userauth.mapper;

import com.easybank.userauth.dto.UserSessionDTO;
import com.easybank.userauth.entity.User;
import com.easybank.userauth.entity.UserSession;

public class UserSessionMapper {

    public static UserSessionDTO toDto(UserSession session) {
        if (session == null) return null;
        UserSessionDTO dto = new UserSessionDTO();
//        dto.setId(session.getId());
//        dto.setUserId(session.getUser().getId());
//        dto.setSessionToken(session.getSessionToken());
//        dto.setIpAddress(session.getIpAddress());
//        dto.setUserAgent(session.getUserAgent());
//        dto.setCreatedAt(session.getCreatedAt());
//        dto.setExpiresAt(session.getExpiresAt());
        return dto;
    }

    public static UserSession toEntity(UserSessionDTO dto) {
        if (dto == null) return null;
        UserSession session = new UserSession();
//        session.setId(dto.getId());
//        session.setSessionToken(dto.getSessionToken());
//        session.setIpAddress(dto.getIpAddress());
//        session.setUserAgent(dto.getUserAgent());
//        session.setCreatedAt(dto.getCreatedAt());
//        session.setExpiresAt(dto.getExpiresAt());
//
//        User user = new User();
//        user.setId(dto.getUserId());
//        session.setUser(user);

        return session;
    }
}
