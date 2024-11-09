package com.example.saboresdecasa.seguridad;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AthenticationController {

    private final AuthentificationService authentificationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authentificationService.register(registerRequest));
    }

    @PostMapping("/authentificate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthentificationRequest registerRequest) {
        return ResponseEntity.ok(authentificationService.authenticate(registerRequest));
    }
}
