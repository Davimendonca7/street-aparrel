package com.auth.service.domain.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoReqDto(
        @NotBlank
        String rua,
        @NotNull
        Integer numero,
        @NotBlank
        String cidade,
        @NotBlank
        String estado,
        @NotBlank
        String cep
) {
}
