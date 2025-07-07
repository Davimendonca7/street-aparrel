package com.streetaparrel.servico_produto.domain.categoria;

import com.streetaparrel.servico_produto.domain.categoria.dto.DadosAtualizarCategoria;
import com.streetaparrel.servico_produto.domain.categoria.dto.DadosCadastroCategoria;
import com.streetaparrel.servico_produto.domain.produto.Produto;
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
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria criarCategoria(DadosCadastroCategoria dados) {

        var categoria = new Categoria(dados);

        categoriaRepository.save(categoria);
        return categoria;
    }

    public List<Categoria> listar() {
        List<Categoria> categoria = categoriaRepository.findAll();
        if(categoria.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return categoria;
    }

    public Categoria encontrarPorId(Long id){
        return categoriaRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Categoria atualizarCategoria(DadosAtualizarCategoria dados){
        var categoria = categoriaRepository.findById(dados.id()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        categoria.atualizarInformacoes(dados);

        return categoria;
    }

//    @Transactional
//    public void deletarCategoria(Long id) {
//        if (id == null){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        var produto = produtoRepository.findById(id).orElseThrow(() ->
//                new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//        produtoRepository.delete(produto);
//    }
}
