package com.testproject.util;

import org.springframework.security.core.AuthenticationException;

public class UnknownUserException extends AuthenticationException {

    public UnknownUserException(String msg, Throwable t) {
        super(msg, t);
    }

    public UnknownUserException(String msg) {
        super(msg);
    }
    
}
