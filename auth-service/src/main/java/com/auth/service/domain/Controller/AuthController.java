package com.auth.service.domain.Controller;


import com.auth.service.domain.DTOs.UserReqDto;
import com.auth.service.domain.Service.AuthService;
import com.auth.service.domain.entity.Usuario;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody @Valid UserReqDto user){

        Usuario usuario = authService.cadastrarUzsuario(user);

//        DadosDetalhesCliente cliente = new DadosDetalhesCliente(c1, new EnderecoResDto(c1.getEndereco()));

//        return ResponseEntity.status(200).body(cliente);
    }
}
