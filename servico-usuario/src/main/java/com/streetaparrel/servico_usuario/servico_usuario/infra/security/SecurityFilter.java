package com.streetaparrel.servico_usuario.servico_usuario.infra.security;

import com.streetaparrel.servico_usuario.servico_usuario.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;


    @Override
    protected void doFilterInternal
            (HttpServletRequest request,
             HttpServletResponse response,
             FilterChain filterChain) throws ServletException, IOException {

        var tokenJwt = recuperarToken(request);

        if(tokenJwt != null) {
            var subject = tokenService.getSubject(tokenJwt);
            var usuario = usuarioRepository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(
                    usuario,
                    null,
                    usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);

        }

    private String recuperarToken(HttpServletRequest request) {
        var AutorizationHeader = request.getHeader("Authorization");

        if(AutorizationHeader != null){

            return AutorizationHeader.replace("Bearer ", "");
        }

        return null;

    }
    }



