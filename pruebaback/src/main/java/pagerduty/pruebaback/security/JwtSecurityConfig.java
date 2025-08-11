package pagerduty.pruebaback.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import pagerduty.pruebaback.utils.JwtConfig;

import java.util.Date;

@Configuration
public class JwtSecurityConfig {

    private final JwtConfig jwtConfig;
    private final Algorithm algorithm;
    private final JWTVerifier verifier;

    public JwtSecurityConfig(JwtConfig jwtConfig){
        this.jwtConfig = jwtConfig;
        this.algorithm = Algorithm.HMAC256(jwtConfig.getSecret());
        this.verifier = JWT.require(algorithm).build();
    }

    public String generateToken(String subject){
        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConfig.getExpiration()))
                .sign(algorithm);
    }

    public boolean verifyToken(String token){
        try{
            verifier.verify(token);
            return true;
        }catch(JWTVerificationException e){
            return false;
        }
    }

    public String getTokenRequest(HttpServletRequest request){
        String tokenHeader = request.getHeader("Authorization");

        if(tokenHeader == null || !tokenHeader.startsWith("Bearer ")){
            return null;
        }

        return tokenHeader.replace("Bearer ", "");
    }

    public String getSubject(String token){
        DecodedJWT decodedJwt = JWT.decode(token);
        return decodedJwt.getSubject();
    }

}
