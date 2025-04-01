package com.streetaparrel.servico_produto.domain.produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProduto(
        @NotNull
        Long id,
        String nome,
        String descricao,
        Double preco,
        String imagemUrl,
        Long categoriaId
) {
}
