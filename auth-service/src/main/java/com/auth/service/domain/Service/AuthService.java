package com.auth.service.domain.Service;

import com.auth.service.domain.DTOs.UserReqDto;
import com.auth.service.domain.Service.messaging.RabbitMQProducer;
import com.auth.service.domain.entity.Cliente;
import com.auth.service.domain.entity.Usuario;
import com.auth.service.domain.enums.Role;
import com.auth.service.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RabbitMQProducer rabbitMQProducer;


    public Usuario cadastrarUsuario(UserReqDto user) {

        if (usuarioRepository.findByUsername(user.login()).isPresent()) {
            throw new RuntimeException("Usuario já existe");
        }

        Usuario usuario = Usuario.builder()
                .role(Role.valueOf(user.role()))
                .username(user.login())
                .senha(user.senha())
                .build();

        usuarioRepository.save(usuario);

        Cliente cliente = new Cliente(user);
        cliente.setId(usuario.getId());

        rabbitMQProducer.sendMessage(cliente);

        return usuario;
    }
}
