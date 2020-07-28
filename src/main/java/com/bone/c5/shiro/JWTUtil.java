package com.bone.c5.shiro;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bone
 */
@Data
@Component
public class JWTUtil implements Serializable {
    private static final String CLAIM_KEY_USERNAME = "sub";

    private static final String secret = "Bone";
    private static final Integer expiration = 36000;
    private static final String header = "Authorization";


    public static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>(16);
        claims.put(CLAIM_KEY_USERNAME, username);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public static Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    private static Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
