package com.example.saboresdecasa.seguridad;

import com.example.saboresdecasa.enumerates.Role;
import com.example.saboresdecasa.repositorios.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentificationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .nombre(registerRequest.getNombre())
                .apellido(registerRequest.getApellido())
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuthentificationRequest registerRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(registerRequest.getUsername(), registerRequest.getPassword()));
        var user = userRepository.findByUsername(registerRequest.getUsername()).orElse(null);
        var token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .build();
    }
}
