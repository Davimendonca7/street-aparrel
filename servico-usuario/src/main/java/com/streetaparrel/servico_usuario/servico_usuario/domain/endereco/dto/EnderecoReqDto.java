package com.streetaparrel.servico_usuario.servico_usuario.domain.endereco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoReqDto(
        @NotBlank
        String rua,
        @NotNull
        Integer numero,
        @NotBlank
        String complemento,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String estado,
        @NotBlank
        String cep,
        @NotBlank
        String pais
) {
}
