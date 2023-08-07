package com.example.student_management_system.security;


import com.example.student_management_system.exception.ApiException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app-jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    //generate JWT token
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        return Jwts.builder()
                .setSubject(username) // set the "sub" claim of the JWT
                .setIssuedAt(currentDate) // set the "iat" claim
                .setExpiration(expireDate) // set the "exp" claim
                .signWith(key())
                .compact();
    }

    private Key key() {
        //generate an HMAC (hash-based message authentication code) key for a given source
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode((jwtSecret)));
    }

    //get username
    public String getUsername(String token) {
        Claims claims = Jwts.parserBuilder()//start the process of building a JWT parser
                .setSigningKey(key())//set signing key that wil be used to verify the signature of the JWT
                .build()//build the JWT parser based on the configuration set up in the previous steps
                .parseClaimsJws(token)//
                .getBody();//retrieve the claims from the parser

        return claims.getSubject();
    }

    //validate JWT token
    public boolean validateToken(String token) throws ApiException {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            throw new ApiException("Invalid JWT token", HttpStatus.BAD_REQUEST);
        } catch (ExpiredJwtException ex) {
            throw new ApiException("Expired JWT token", HttpStatus.BAD_REQUEST);
        } catch (UnsupportedJwtException ex){
            throw new ApiException("Unsupported JWT token", HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException ex){
            throw new ApiException("JWT claims string is empty", HttpStatus.BAD_REQUEST);
        }
    }

}
