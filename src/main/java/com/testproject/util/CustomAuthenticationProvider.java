package com.testproject.util;

import com.testproject.model.User;
import com.testproject.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.Map;

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
            throw new UnknownUserException("Invalid username or password");
        }
        Map<String, String> userCredentials = setUserCredentials(token);
        return new UserAuthenticationToken(user, userCredentials);
    }

    private Map<String, String> setUserCredentials(Authentication auth) {
        Map<String, String> userCredentials = new HashMap<>();
        userCredentials.put("username", auth.getName());
        userCredentials.put("password", (String) auth.getCredentials());
        return userCredentials;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UserAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
