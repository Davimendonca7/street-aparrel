package com.streetaparrel.servico_produto.domain.produto;

import com.streetaparrel.servico_produto.domain.categoria.Categoria;
import com.streetaparrel.servico_produto.domain.categoria.CategoriaService;
import com.streetaparrel.servico_produto.domain.produto.dto.DadosAtualizarProduto;
import com.streetaparrel.servico_produto.domain.produto.dto.DadosCadastroProduto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaService categoriaService;

    @Transactional
    public Produto criarProduto(DadosCadastroProduto dados) {
        Categoria categoria = categoriaService.encontrarPorId(dados.categoriaId());

        var produto = new Produto(dados);
        produto.setCategoria(categoria);

        produtoRepository.save(produto);
        return produto;
    }

    public List<Produto> listar() {
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return produtos;
    }
    
    public Produto encontrarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Produto atualizarProduto(DadosAtualizarProduto dados){
        Categoria categoria = categoriaService.encontrarPorId(dados.categoriaId());

        var produto = produtoRepository.findById(dados.id()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        produto.atualizarInformacoes(dados, categoria);

        return produto;
    }

    @Transactional
    public void deletarProduto(Long id) {
        if (id == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        var produto = produtoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        produtoRepository.delete(produto);
    }
}
