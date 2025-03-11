package com.auth.service.domain.Service;

import com.auth.service.domain.DTOs.UserReqDto;
import com.auth.service.domain.entity.Usuario;
import com.auth.service.domain.enums.Role;
import com.auth.service.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;


    public Usuario cadastrarUsuario(UserReqDto user) {

        if (usuarioRepository.findByUsername(user.login()).isPresent()) {
            throw new RuntimeException("Usuario já existe");
        }

        Usuario usuario = Usuario.builder()
                .role(user.role())
                .username(user.login())
                .senha(user.senha())
                .build();

        usuarioRepository.save(usuario);

        return usuario;
    }
}
