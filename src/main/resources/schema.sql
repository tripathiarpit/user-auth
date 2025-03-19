-- Users table
CREATE TABLE IF NOT EXISTS users (
                                     id CHAR(36) PRIMARY KEY,
                                     customer_id BIGINT NOT NULL,
                                     username VARCHAR(50) UNIQUE NOT NULL,
                                     email VARCHAR(100) UNIQUE NOT NULL,
                                     password_hash VARCHAR(255) NOT NULL,
                                     is_active TINYINT(1) DEFAULT 1, -- MySQL does not have BOOLEAN, so we use TINYINT(1)
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Roles table
CREATE TABLE IF NOT EXISTS roles (
                                     id CHAR(36) PRIMARY KEY,
                                     role_name VARCHAR(50) UNIQUE NOT NULL,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- User roles mapping table
CREATE TABLE IF NOT EXISTS user_roles (
                                          user_id CHAR(36) NOT NULL,
                                          role_id CHAR(36) NOT NULL,
                                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                          PRIMARY KEY (user_id, role_id),
                                          FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                                          FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Permissions table
CREATE TABLE IF NOT EXISTS permissions (
                                           id CHAR(36) PRIMARY KEY,
                                           permission_name VARCHAR(50) UNIQUE NOT NULL,
                                           description TEXT,
                                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Role permissions mapping table
CREATE TABLE IF NOT EXISTS role_permissions (
                                                role_id CHAR(36) NOT NULL,
                                                permission_id CHAR(36) NOT NULL,
                                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                PRIMARY KEY (role_id, permission_id),
                                                FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE,
                                                FOREIGN KEY (permission_id) REFERENCES permissions(id) ON DELETE CASCADE
);

-- User sessions table
CREATE TABLE IF NOT EXISTS user_sessions (
                                             id CHAR(36) PRIMARY KEY,
                                             user_id CHAR(36) NOT NULL,
                                             session_token VARCHAR(255) UNIQUE NOT NULL,
                                             ip_address VARCHAR(45),
                                             user_agent TEXT,
                                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                             expires_at TIMESTAMP NOT NULL,
                                             FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Audit logs table
CREATE TABLE IF NOT EXISTS audit_logs (
                                          id CHAR(36) PRIMARY KEY,
                                          user_id CHAR(36),
                                          action VARCHAR(100) NOT NULL,
                                          timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                          details TEXT,
                                          FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);
