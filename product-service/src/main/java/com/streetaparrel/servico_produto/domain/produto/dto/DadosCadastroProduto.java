package com.streetaparrel.servico_produto.domain.produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Double preco,
        @NotBlank
        String imagemUrl,
        @NotNull
        Long categoriaId
) {
}
