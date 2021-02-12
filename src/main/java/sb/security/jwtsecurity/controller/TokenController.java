package sb.security.jwtsecurity.controller;

import com.auth0.jwt.JWT;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sb.security.jwtsecurity.common.JwtProperties;
import sb.security.jwtsecurity.config.UserPrincipalDetailService;
import sb.security.jwtsecurity.model.UserCredentials;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@RestController
public class TokenController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserPrincipalDetailService userPrincipalDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/createToken")
    public ResponseEntity<?> createToken(@RequestBody UserCredentials userCredentials) throws Exception {
        Long now = System.currentTimeMillis();

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword()));
        } catch (BadCredentialsException e){
            throw new Exception("Username or password incorrect");
        }

        String token = JWT.create().withSubject(userCredentials.getUsername()).withIssuedAt(new Date(now))
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }
}
