package com.example.task_management.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");

        // JWT Token is in the form "Bearer token". Remove Bearer word and get only the
        // Token
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

        } else {
            logger.warn("JWT Token does not begin with Bearer String");
        }
        filterChain.doFilter(request, response);
    }
}
