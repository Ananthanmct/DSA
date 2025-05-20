package com.tmdb.auth_api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JwtUtil {


    @Value("${auth.secret.password}")
    String secretPassword;

    Long expirationTime = 1000000L; // 10 mins

    public String generateToken(String userId, String password, String role){ // email & password
        String information = userId + ":" + password + ":" + role;
        String jwtToken = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secretPassword)
                .setSubject(information)
                .compact();
        return jwtToken;
    }

    public String decryptToken(String token){
        String credentials = Jwts.parser().setSigningKey(secretPassword)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return credentials;

    }

    public boolean verifyToken(String token){
        // decrypt the token
        String credentials = this.decryptToken(token);
        String email = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        AppUser user  = dbapi.callGetUserByEmailEndpoint(email);
        if(user == null){
            return false;
        }
        if(user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
