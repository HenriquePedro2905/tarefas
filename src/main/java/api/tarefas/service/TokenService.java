package api.tarefas.service;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import api.tarefas.dolmain.users.Users;

@Service
public class TokenService {

    private String secret;

    public String generateToken(Users users){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("tarefas")
                .withSubject(users.getLogin())
                .sign(algorithm);
                return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("erro", e);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                .withIssuer("tarefas")
                .build()
                .verify(token)
                .getSubject();
        } catch(JWTVerificationException e){
            return "";
        }
    }
}
