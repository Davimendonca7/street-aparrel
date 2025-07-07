package com.auth.service.domain.DTOs.user;

import com.auth.service.domain.DTOs.endereco.EnderecoReqDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserReqDto(
        @NotBlank
        String role,
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
