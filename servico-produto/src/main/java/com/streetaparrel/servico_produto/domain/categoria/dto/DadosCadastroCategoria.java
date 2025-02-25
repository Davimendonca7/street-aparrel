package com.streetaparrel.servico_produto.domain.categoria.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria(
        @NotBlank
        String nome,
        @NotBlank
        String descricao
) {
}
