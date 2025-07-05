package com.auth.service.domain.Service;

import com.auth.service.config.jwt.JwtTokenService;
import com.auth.service.domain.DTOs.login.LoginReqDto;
import com.auth.service.domain.DTOs.user.UserReqDto;
import com.auth.service.domain.DTOs.userservice.UserDto;
import com.auth.service.domain.Service.messaging.RabbitMQProducer;
import com.auth.service.domain.entity.Cliente;
import com.auth.service.domain.entity.Usuario;
import com.auth.service.domain.enums.Role;
import com.auth.service.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RabbitMQProducer rabbitMQProducer;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final String userServiceUrl = "http://user-service/clientes/";


//    @LoadBalanced
//    @Autowired
//    private RestTemplate restTemplate;

    public Usuario cadastrarUsuario(UserReqDto user) {

        if (usuarioRepository.existsByUsername(user.login())) {
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

    public String login(LoginReqDto login) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.username(), login.password())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = jwtTokenService.generateToken((Usuario) userDetails);

//        salvarCache((Usuario) userDetails);

        return token;

    }

//    public void salvarCache(Usuario usuario){
//
//        UserDto dadosUsuario = restTemplate.getForObject(
//                userServiceUrl + usuario.getId(),
//                UserDto.class
//        );
//
//
//    }


}
