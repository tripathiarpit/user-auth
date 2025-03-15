package com.easybank.userauth.repository;
import com.easybank.userauth.entity.Roles;
import com.easybank.userauth.entity.UserRolesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<Roles, UserRolesId> {
}
