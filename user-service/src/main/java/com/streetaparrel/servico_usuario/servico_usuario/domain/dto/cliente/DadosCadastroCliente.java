package com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente;

import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco.EnderecoReqDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosCadastroCliente(
        @NotBlank
        UUID id,
        @NotBlank
        String nome,
        @NotNull
        String cpf,
        @NotBlank
        String telefone,
        @Valid
        EnderecoReqDto endereco
) {
}
