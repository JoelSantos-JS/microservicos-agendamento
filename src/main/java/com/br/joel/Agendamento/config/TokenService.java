package com.br.joel.Agendamento.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.br.joel.Agendamento.domain.User;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class TokenService {


    private String  secret = "JWT_SECRET";
    public  String generateToken(User user) throws Exception {


        try {
            Algorithm algorithm  = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(getExpiration())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException e) {
            throw  new Exception("Erro ao gerar token");

        }
    }


    public  String validateToken(String token) throws Exception {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return  JWT.require(algorithm).withIssuer("auth-api").build().verify(token).getSubject();

        }catch (Exception e){
            throw  new Exception("Token inválido");
        }

    }

    private Instant  getExpiration(){
        return LocalDateTime.now().plusSeconds(60 * 60 * 24 * 30).toInstant(java.time.ZoneOffset.UTC);
    }
}
