package com.auth.service.domain.Controller;

import com.auth.service.domain.controller.AuthController;
import com.auth.service.domain.DTOs.EnderecoReqDto;
import com.auth.service.domain.DTOs.UserReqDto;
import com.auth.service.domain.DTOs.UserResDto;
import com.auth.service.domain.Service.AuthService;
import com.auth.service.domain.entity.Usuario;
import com.auth.service.domain.enums.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)  // Inicializa os Mocks do Mockito
//@WebMvcTest(AuthController.class)
class AuthControllerTest {

//    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    private UserReqDto userReqDto;


    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
//        MockitoAnnotations.openMocks(this);

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
    void testeCreateUser_Success() throws Exception{

        Usuario usuarioMock = Usuario.builder()
                .username(userReqDto.login())
                .senha(userReqDto.senha())
                .role(Role.valueOf(userReqDto.role()))
                .build();

        when(authService.cadastrarUsuario(userReqDto)).thenReturn(usuarioMock);

        UserResDto userResDto = new UserResDto(usuarioMock);

        mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userReqDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.login").value(userResDto.login()))
                .andExpect(jsonPath("$.role").value(userResDto.role()));
    }
}