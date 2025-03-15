package com.easybank.userauth.constants;

public class SessionConstants {
    public static final int SESSION_EXPIRATION_HOURS = 24;
    public static final int SESSION_EXPIRATION_DAYS = 7;

    public static final String SESSION_HEADER_NAME = "Authorization";
    public static final String SESSION_PREFIX = "Bearer ";

    private SessionConstants() {
    }
}
