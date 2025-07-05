package com.auth.service.domain.Service;

import com.auth.service.domain.DTOs.endereco.EnderecoReqDto;
import com.auth.service.domain.DTOs.user.UserReqDto;
import com.auth.service.domain.Service.messaging.RabbitMQProducer;
import com.auth.service.domain.entity.Cliente;
import com.auth.service.domain.entity.Usuario;
import com.auth.service.domain.enums.Role;
import com.auth.service.domain.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.mockito.Mockito.*;


class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private RabbitMQProducer rabbitMQProducer;

    private UserReqDto userReqDto;

    private EnderecoReqDto enderecoReqDto;

    private Role role;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

         userReqDto = new UserReqDto(
                "USER",
                "login_9e8475d36688",
                "senha_9c46dfc3456a",
                "nome_011199a1eb70",
                "cpf_950c389b3209",
                "telefone_305acefca91a",
                new EnderecoReqDto(
                        "rua_009d26b79882",
                        0,
                        "cidade_312973bcdf3b",
                        "estado_35aba24a0765",
                        "cep_44a81e3e4b80"
                )
        );
    }

    @Test
    void testCadastrarUsuario_Success(){
        when(usuarioRepository.findByUsername(userReqDto.login())).thenReturn(Optional.empty());

        Usuario usuarioMock = Usuario.builder()
                .role(Role.valueOf(userReqDto.role()))
                .username(userReqDto.login())
                .senha(userReqDto.senha())
                .build();

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioMock);

        Usuario usuario = authService.cadastrarUsuario(userReqDto);

        assertNotNull(usuario);
        assertEquals(userReqDto.login(), usuario.getUsername());

        verify(rabbitMQProducer, times(1)).sendMessage(any(Cliente.class));
    }

    @Test
    void testCadastrarUsuario_UsuarioExistente(){
        when(usuarioRepository.findByUsername(userReqDto.login())).thenReturn(Optional.of(new Usuario()));

        Exception exception = assertThrows(RuntimeException.class, () -> {
           authService.cadastrarUsuario(userReqDto);
        });

        assertEquals("Usuario já existe", exception.getMessage());

    }
}