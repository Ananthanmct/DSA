package com.youtube.central.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${central.security.secret.key}")
    String secretKey;

    Long expirationTime = 1200000L;

    //Create JWT Token on the basis of creneditial
    // As I mentioned in jwt token you are encrypting some information
    // What information we are going to encrypt we are going to encrypt user credentials
    // credentails = tiwarisomendra22@gmail.com:123456
    // We got the credentials generateToken function we will encrypt credentials with the help of algorithm and secret key

    public String generateToken(String credentials){
            String jwtToken = Jwts.builder().setSubject(credentials)
                    .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();
            return jwtToken;
    }

}
