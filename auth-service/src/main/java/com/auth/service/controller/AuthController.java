package com.auth.service.controller;


import com.auth.service.domain.DTOs.login.LoginReqDto;
import com.auth.service.domain.DTOs.login.LoginResDto;
import com.auth.service.domain.DTOs.user.UserReqDto;
import com.auth.service.domain.DTOs.user.UserResDto;
import com.auth.service.domain.Service.AuthService;
import com.auth.service.domain.entity.Usuario;
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
    public ResponseEntity<UserResDto> createUser(@RequestBody @Valid UserReqDto user){

        Usuario usuario = authService.cadastrarUsuario(user);
        UserResDto userRes = new UserResDto(usuario);

        return ResponseEntity.status(200).body(userRes);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResDto> login(@RequestBody @Valid LoginReqDto login){
        return ResponseEntity.ok(new LoginResDto(authService.login(login)));
    }
}
