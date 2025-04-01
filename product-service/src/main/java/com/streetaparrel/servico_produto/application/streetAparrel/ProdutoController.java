package com.streetaparrel.servico_produto.application.streetAparrel;

import com.streetaparrel.servico_produto.domain.produto.ProdutoService;
import com.streetaparrel.servico_produto.domain.produto.dto.DadosAtualizarProduto;
import com.streetaparrel.servico_produto.domain.produto.dto.DadosCadastroProduto;
import com.streetaparrel.servico_produto.domain.produto.dto.DadosDetalhesProduto;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<DadosDetalhesProduto> criar(
            @RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder){
        DadosDetalhesProduto produto = new DadosDetalhesProduto(produtoService.criarProduto(dados));
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.id()).toUri();

        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhesProduto>> listar(){
        List<DadosDetalhesProduto> produtos = produtoService.listar().stream()
                .map(DadosDetalhesProduto::new).toList();

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhesProduto> encontrarPorId(@PathVariable Long id){
        DadosDetalhesProduto produto = new DadosDetalhesProduto(produtoService.encontrarPorId(id));

        return ResponseEntity.ok(produto);
    }

    @PutMapping
    public ResponseEntity<DadosDetalhesProduto> atualizarProduto(@RequestBody @Valid DadosAtualizarProduto dados){
        DadosDetalhesProduto produto = new DadosDetalhesProduto(produtoService.atualizarProduto(dados));

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);

        return ResponseEntity.noContent().build();
    }
}
