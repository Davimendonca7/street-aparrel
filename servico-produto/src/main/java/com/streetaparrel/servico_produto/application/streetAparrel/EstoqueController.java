package com.streetaparrel.servico_produto.application.streetAparrel;

import com.streetaparrel.servico_produto.domain.estoque.EstoqueService;
import com.streetaparrel.servico_produto.domain.estoque.dto.DadosAtualizarEstoque;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoques")
@RequiredArgsConstructor
public class EstoqueController {

    private final EstoqueService estoqueService;

    @PutMapping
    public ResponseEntity<Void> atualizarEstoque(@RequestBody @Valid DadosAtualizarEstoque dados){
        estoqueService.atualizarEstoque(dados);
        return ResponseEntity.noContent().build();
    }
}
