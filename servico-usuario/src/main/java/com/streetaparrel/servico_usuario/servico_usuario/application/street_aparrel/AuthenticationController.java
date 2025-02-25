package com.streetaparrel.servico_usuario.servico_usuario.application.street_aparrel;

import com.streetaparrel.servico_usuario.servico_usuario.domain.authentication.AuthenticationService;
import com.streetaparrel.servico_usuario.servico_usuario.domain.usuario.Usuario;
import com.streetaparrel.servico_usuario.servico_usuario.domain.usuario.dto.DadosLogin;
import com.streetaparrel.servico_usuario.servico_usuario.infra.security.DadosTokenJwt;
import com.streetaparrel.servico_usuario.servico_usuario.infra.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService authenticationService;

//    private final UsuarioService usuarioService;

    @Operation(summary = "Efetua login e gera um token JWT", description = "Realiza a autenticação do usuário e retorna um token JWT.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login efetuado com sucesso, token JWT retornado"),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas"),
            @ApiResponse(responseCode = "400", description = "Dados de login inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<DadosTokenJwt> efetuarLogin(@RequestBody @Valid DadosLogin dadosLogin){
       String JwtToken = authenticationService.efetuarLogin(dadosLogin);

       return ResponseEntity.ok(new DadosTokenJwt(JwtToken));
    }


}

