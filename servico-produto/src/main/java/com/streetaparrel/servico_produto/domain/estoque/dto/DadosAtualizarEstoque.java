package com.streetaparrel.servico_produto.domain.estoque.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarEstoque(
        @NotNull
        Long ProdutoId,
        @NotNull
        Integer quantidade
) {
}
