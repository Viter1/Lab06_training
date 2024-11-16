package com.vitech.Lab06_training.servicio.Impl;

import com.vitech.Lab06_training.dto.JwtResponse;
import com.vitech.Lab06_training.dto.SingUpRequest;
import com.vitech.Lab06_training.modelo.Usuario;
import com.vitech.Lab06_training.repositorio.UsuarioRepositorio;
import com.vitech.Lab06_training.servicio.ServicioUsuario;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AutentificacionServicio {

    private final UsuarioRepositorio usuarioRepositorio;
    private final ServicioUsuario servicioUsuario;
    private final PasswordEncoder passwordEncoder;
    private final JwtServicio jwtServicio;
    private final AuthenticationManager authenticationManager;

    public JwtResponse signUp(SingUpRequest request) throws BadRequestException {
        var user = Usuario
                .builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("ROLE_USER").build();

        user = servicioUsuario.save(user);
        var jwt = jwtServicio.generateToken(user);
        return JwtResponse.builder().token(jwt).build();
    }
}
