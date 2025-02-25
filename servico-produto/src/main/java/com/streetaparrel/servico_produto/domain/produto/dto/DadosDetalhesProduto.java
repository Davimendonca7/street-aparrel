package com.streetaparrel.servico_produto.domain.produto.dto;


import com.streetaparrel.servico_produto.domain.produto.Produto;

public record DadosDetalhesProduto(
        Long id,
        String nome,
        String descricao,
        Double preco,
        String imagemUrl,
        String categoriaId
) {
    public DadosDetalhesProduto(Produto produto){
        this(produto.getId(), produto.getName(), produto.getDescricao(), produto.getPreco(),
                produto.getImagemUrl(), produto.getCategoria().getNome());
    }
}
