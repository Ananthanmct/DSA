package com.tmdb.auth_api.security;

import com.tmdb.auth_api.connector.DBAPI;
import com.tmdb.auth_api.models.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Autowired
    DBAPI dbapi;

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
        Employee emp  = dbapi.callGetEmployeeByEmailEndpoint(email);
        if(emp == null){
            return false;
        }
        if(emp.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
