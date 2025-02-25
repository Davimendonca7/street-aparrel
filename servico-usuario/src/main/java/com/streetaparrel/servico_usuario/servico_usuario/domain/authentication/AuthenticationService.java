package com.streetaparrel.servico_usuario.servico_usuario.domain.authentication;

import com.streetaparrel.servico_usuario.servico_usuario.domain.usuario.Usuario;
import com.streetaparrel.servico_usuario.servico_usuario.domain.usuario.dto.DadosLogin;
import com.streetaparrel.servico_usuario.servico_usuario.infra.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public String efetuarLogin(DadosLogin dadosLogin){
        var Autenticacaotoken = new UsernamePasswordAuthenticationToken(dadosLogin.login(), dadosLogin.senha());
        var autenticacao = manager.authenticate(Autenticacaotoken);

        return tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
    }
}
