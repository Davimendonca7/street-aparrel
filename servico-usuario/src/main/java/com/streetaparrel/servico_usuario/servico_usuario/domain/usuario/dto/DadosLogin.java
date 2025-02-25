package com.streetaparrel.servico_usuario.servico_usuario.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(
        @NotBlank
        String login,
        @NotBlank
        String senha) {

}

