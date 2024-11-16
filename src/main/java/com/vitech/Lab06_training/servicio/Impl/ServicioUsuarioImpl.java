package com.vitech.Lab06_training.servicio.Impl;

import com.vitech.Lab06_training.modelo.Usuario;
import com.vitech.Lab06_training.repositorio.UsuarioRepositorio;
import com.vitech.Lab06_training.servicio.ServicioUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioUsuarioImpl implements ServicioUsuario {


    public UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario save(Usuario newUser) {
        return usuarioRepositorio.save(newUser);
    }
}
