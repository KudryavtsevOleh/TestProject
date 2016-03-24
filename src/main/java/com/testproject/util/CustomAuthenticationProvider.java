package com.testproject.util;

import com.testproject.model.User;
import com.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import com.testproject.util.UnknownUserException;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserAuthenticationToken token = (UserAuthenticationToken) authentication;
        String username = token.getName();
        String password = (String) token.getCredentials();
        User user = userService.getUserByUsernameAndPassword(username, password);
        if (null == user) {
            throw new UnknownUserException("Could not find user with username: " + username + " and password: " + password);
        }
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UserAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
