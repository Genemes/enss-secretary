package com.siloe.enss.entrypoint.rest;

import com.siloe.enss.domain.dto.LoginRequestDTO;
import com.siloe.enss.entrypoint.vo.LoginVO;
import com.siloe.enss.entrypoint.vo.StudentVO;
import com.siloe.enss.infraestructure.presentation.AccountPresentation;
import com.siloe.enss.infraestructure.presentation.EmailPresentation;
import com.siloe.enss.infraestructure.presentation.RolePresentation;
import com.siloe.enss.infraestructure.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableMethodSecurity
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public TokenController(JwtEncoder jwtEncoder, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginVO> login(@RequestBody LoginRequestDTO loginRequest){
        EmailPresentation email = EmailPresentation.of(loginRequest.username());
        var user = userRepository.findByEmail(email);
        if(user.isEmpty() || !user.get().isLoginCorrect(loginRequest, bCryptPasswordEncoder)) {
            throw new BadCredentialsException("user or password is invalid");
        }

        var now  = Instant.now();
        var expiresIn = 300L;

        var scopes = user.get().getRoles().stream()
                .map(RolePresentation::getName)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("enss-backend")
                .subject(user.get().getUsername().toString())
                .issuedAt(Instant.now())
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", scopes)
                .build();
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginVO(jwtValue, expiresIn));
    }


    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<AccountPresentation>> listStudents() {
//        logger.info("M=list, message=Controller, request to list a successfully received Student");

        var users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

}
