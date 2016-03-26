package com.testproject.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;

public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String login = request.getHeader("X-Login");
        String password = request.getHeader("X-Password");

        if (StringUtils.isBlank(login) || StringUtils.isBlank(password)) {
            filterChain.doFilter(request, response);
            return;
        }

        Authentication token = authenticationProvider.authenticate(new UserAuthenticationToken(login, password));
        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(request, response);
    }

}
