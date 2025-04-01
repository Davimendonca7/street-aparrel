package com.streetaparrel.servico_produto.domain.categoria.dto;


import com.streetaparrel.servico_produto.domain.categoria.Categoria;

public record DadosDetalhesCategoria(
        Long id,
        String nome,
        String descricao
) {
    public DadosDetalhesCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
