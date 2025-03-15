package com.easybank.userauth.repository;

import com.easybank.userauth.entity.User;
import com.easybank.userauth.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Long> {

    Optional<UserSession> findBySessionToken(String sessionToken);

    void deleteBySessionToken(String sessionToken);

    void deleteByUser(User user);

    void deleteByUserId(Long userId);
}
