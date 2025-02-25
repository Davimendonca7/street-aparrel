package com.streetaparrel.servico_produto.domain.estoque.dto;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroEstoque(
        @NotNull
        Long produtoId,
        @NotNull
        Integer quantidade
) {
}
