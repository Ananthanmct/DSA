package com.tmdb.auth_api.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {


    // /verify-token -> protected
    // /generate-token -> not protected

    @Autowired
    JwtUtil jwtUtil;


    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Inside filter");
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            String token = bearerToken.substring(7);
            // We got the token now we need to validate that this token is a genuine token or not.
            boolean isValid = jwtUtil.verifyToken(token);
            if(isValid == false){
                // I am not going to set any kind of authentication and i will return from here it self
                // before filtering if i am not setting any kind of authetication that
                // means i am rejecting the reuquest
                filterChain.doFilter(request, response);
                return;
            }
            String crednetials = jwtUtil.decryptToken(token);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(crednetials, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response); // If you are not setting up username and password authenthication that means you are rejecting token
    }

}
