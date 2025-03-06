package com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.dto;

import com.streetaparrel.servico_usuario.servico_usuario.domain.endereco.dto.EnderecoReqDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        @NotBlank
        String login,
        @NotBlank
        String senha,
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
