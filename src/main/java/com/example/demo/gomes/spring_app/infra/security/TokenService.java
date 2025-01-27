package com.example.demo.gomes.spring_app.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.gomes.spring_app.models.PessoaModel;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(PessoaModel pessoa) {
        try {
            Algorithm  algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                .withIssuer("login-auth-api")
                .withSubject(pessoa.getCpf())
                .withExpiresAt(this.genrateExpirationDate())
                .sign(algorithm);

            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm  algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                .withIssuer("login-auth-api")
                .build()
                .verify(token)
                .getSubject();
                
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    private Instant genrateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
