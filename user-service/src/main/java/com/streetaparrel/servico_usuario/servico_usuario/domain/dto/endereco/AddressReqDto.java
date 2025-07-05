package com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressReqDto(
        @NotBlank
        String rua,
        @NotNull
        String numero,
        @NotBlank
        String cidade,
        @NotBlank
        String estado,
        @NotBlank
        String cep
) {
}
