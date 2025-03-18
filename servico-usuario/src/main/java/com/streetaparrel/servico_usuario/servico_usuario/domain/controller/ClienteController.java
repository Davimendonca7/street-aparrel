package com.streetaparrel.servico_usuario.servico_usuario.domain.controller;

import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Cliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.service.ClienteService;
import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente.DadosCadastroCliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente.DadosDetalhesCliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco.EnderecoResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
@Tag(name = "Usuários", description = "Endpoints para gerenciar usuários")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @Operation(summary = "Lista todos os usuários", description = "Retorna uma lista com todos os usuários cadastrados")
    public ResponseEntity<DadosDetalhesCliente> cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dadosCadastro){

        Cliente c1 = clienteService.cadastrarCliente(dadosCadastro);

        DadosDetalhesCliente cliente = new DadosDetalhesCliente(c1, new EnderecoResDto(c1.getEndereco()));

        return ResponseEntity.status(200).body(cliente);
    }

}
