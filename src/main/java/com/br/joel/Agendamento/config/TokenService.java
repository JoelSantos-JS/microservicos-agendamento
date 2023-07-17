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

@Service
public class TokenService {

@Value("${token.secret}")
    private String  secret = "XXXX";

    public  String generateToken(User user) throws Exception {


        try {
            Algorithm algorithm  = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withClaim("email", user.getLogin())
                    .withExpiresAt(getExpiration())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException e) {
            throw  new Exception("Erro ao gerar token");

        }
    }


    private Instant  getExpiration(){
        return Instant.now().plusSeconds(60 * 60 * 24 * 30);
    }
}
