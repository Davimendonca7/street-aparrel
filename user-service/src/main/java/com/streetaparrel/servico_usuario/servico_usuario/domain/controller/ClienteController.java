package com.streetaparrel.servico_usuario.servico_usuario.domain.controller;

import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Cliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.service.ClientService;
import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente.ClientReqDto;
import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente.ClientResDto;
import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco.AddressResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
@Tag(name = "Usuários", description = "Endpoints para gerenciar usuários")
public class ClienteController {

    private final ClientService clienteService;

    @PostMapping
    @Operation(summary = "Cadastro de clientes", description = "Cadastro de clientes")
    public ResponseEntity<ClientResDto> cadastrarCliente(@RequestBody @Valid ClientReqDto dadosCadastro){

        Cliente c1 = clienteService.cadastrarCliente(dadosCadastro);

        ClientResDto cliente = new ClientResDto(c1, new AddressResDto(c1.getEndereco()));

        return ResponseEntity.status(200).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResDto> buscarClientePorId(@PathVariable Long id){
        Cliente cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(new ClientResDto(cliente, new AddressResDto(cliente.getEndereco())));
    }

}
