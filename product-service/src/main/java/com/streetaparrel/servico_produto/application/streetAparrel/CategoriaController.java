package com.streetaparrel.servico_produto.application.streetAparrel;

import com.streetaparrel.servico_produto.domain.categoria.CategoriaService;
import com.streetaparrel.servico_produto.domain.categoria.dto.DadosAtualizarCategoria;
import com.streetaparrel.servico_produto.domain.categoria.dto.DadosCadastroCategoria;
import com.streetaparrel.servico_produto.domain.categoria.dto.DadosDetalhesCategoria;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<DadosDetalhesCategoria> criar(
            @RequestBody @Valid DadosCadastroCategoria dados, UriComponentsBuilder uriBuilder){
        DadosDetalhesCategoria categoria = new DadosDetalhesCategoria(categoriaService.criarCategoria(dados));
        var uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.id()).toUri();

        return ResponseEntity.created(uri).body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhesCategoria>> listar(){
        List<DadosDetalhesCategoria> categoria = categoriaService.listar().stream()
                .map(DadosDetalhesCategoria::new).toList();

        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhesCategoria> encontrarPorId(@PathVariable Long id){
        DadosDetalhesCategoria categoria = new DadosDetalhesCategoria(categoriaService.encontrarPorId(id));

        return ResponseEntity.ok(categoria);
    }

    @PutMapping
    public ResponseEntity<DadosDetalhesCategoria> atualizarProduto(@RequestBody @Valid DadosAtualizarCategoria dados){
        DadosDetalhesCategoria categoria = new DadosDetalhesCategoria(categoriaService.atualizarCategoria(dados));

        return ResponseEntity.ok(categoria);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
//        categoriaService.deletarProduto(id);
//
//        return ResponseEntity.noContent().build();
//    }
}
