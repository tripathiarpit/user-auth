CREATE TABLE users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       customer_id BIGINT NOT NULL,
                       FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       is_active BOOLEAN DEFAULT TRUE,
                       created_at TIMESTAMP DEFAULT NOW(),
                       updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE roles (
                       id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
                       role_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE user_roles (
                            user_id CHAR(36) REFERENCES users(id) ON DELETE CASCADE,
                            role_id CHAR(36) REFERENCES roles(id) ON DELETE CASCADE,
                            PRIMARY KEY (user_id, role_id)
);

CREATE TABLE permissions (
                             id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
                             permission_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE role_permissions (
                                  role_id CHAR(36) REFERENCES roles(id) ON DELETE CASCADE,
                                  permission_id CHAR(36) REFERENCES permissions(id) ON DELETE CASCADE,
                                  PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE user_sessions (
                               id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
                               user_id CHAR(36) REFERENCES users(id) ON DELETE CASCADE,
                               session_token VARCHAR(255) UNIQUE NOT NULL,
                               ip_address VARCHAR(45),
                               user_agent TEXT,
                               created_at TIMESTAMP DEFAULT NOW(),
                               expires_at TIMESTAMP NOT NULL
);
CREATE TABLE audit_logs (
                            id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
                            user_id CHAR(36) REFERENCES users(id) ON DELETE SET NULL,
                            action VARCHAR(100) NOT NULL,
                            timestamp TIMESTAMP DEFAULT NOW(),
                            details TEXT
);
