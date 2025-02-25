package com.streetaparrel.servico_produto.domain.estoque;

import com.streetaparrel.servico_produto.domain.estoque.dto.DadosAtualizarEstoque;
import com.streetaparrel.servico_produto.domain.estoque.dto.DadosCadastroEstoque;
import com.streetaparrel.servico_produto.domain.produto.Produto;
import com.streetaparrel.servico_produto.domain.produto.ProdutoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final ProdutoService produtoService;

    @Transactional
    public Estoque criarEstoque(DadosCadastroEstoque dados) {
        Produto produto = produtoService.encontrarPorId(dados.produtoId());

        var estoque = new Estoque(dados);
        estoque.setProduto(produto);

        estoqueRepository.save(estoque);
        return estoque;
    }

    public List<Estoque> listar() {
        List<Estoque> estoque = estoqueRepository.findAll();
        if(estoque.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return estoque;
    }

    public Estoque encontrarPorId(Long id){
        return estoqueRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Estoque atualizarEstoque(DadosAtualizarEstoque dados){
       Produto produto = produtoService.encontrarPorId(dados.ProdutoId());

       Estoque estoque = estoqueRepository.findByProdutoId(dados.ProdutoId());

       estoque.atualizarInformacoes(dados);

        return estoque;
    }

//    @Transactional
//    public void deletarEstoque(Long id) {
//        if (id == null){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        var produto = produtoRepository.findById(id).orElseThrow(() ->
//                new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//        produtoRepository.delete(produto);
//    }
}


