package com.auth.service.config;

import com.auth.service.domain.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenService {

    private final String secretKey = "teste123";

    public String generateToken(Usuario usuario){
        return JWT.create()
                .withSubject(usuario.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .sign(Algorithm.HMAC256(secretKey));
    }

    public String extractUsername(String token){
        return JWT.require(Algorithm.HMAC256(secretKey))
                .build()
                .verify(token)
                .getSubject();

    }

    public Boolean validateToken(String token, Usuario usuario){
        return usuario.getUsername().equalsIgnoreCase(extractUsername(token));
    }

}
