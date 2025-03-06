package com.auth.service.config;

import com.auth.service.domain.entity.Usuario;
import com.auth.service.domain.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
        ) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        final String token = authHeader.substring(7);
        final String username = jwtTokenService.extractUsername(token);

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = usuarioRepository.findByUsername(username);

            if(jwtTokenService.validateToken(token, (Usuario) userDetails)){
                UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );

             authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
             SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
