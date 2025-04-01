package com.streetaparrel.servico_produto.domain.categoria.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCategoria(
        @NotNull
        Long id,
        String nome,
        String descricao
) {
}
