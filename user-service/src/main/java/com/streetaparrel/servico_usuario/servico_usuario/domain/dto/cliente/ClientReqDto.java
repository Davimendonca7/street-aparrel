package com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente;

import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco.AddressReqDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClientReqDto(
        @NotBlank
        String id,
        @NotBlank
        String nome,
        @NotNull
        String cpf,
        @NotBlank
        String telefone,
        @Valid
        AddressReqDto endereco
) {
}
