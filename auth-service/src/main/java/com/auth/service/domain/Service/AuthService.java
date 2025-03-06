package com.auth.service.domain.Service;

import com.auth.service.domain.entity.Usuario;
import com.auth.service.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;


}
