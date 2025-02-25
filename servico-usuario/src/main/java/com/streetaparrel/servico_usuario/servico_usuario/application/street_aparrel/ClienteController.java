package com.streetaparrel.servico_usuario.servico_usuario.application.street_aparrel;

import com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.ClienteService;
import com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.dto.DadosCadastroCliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.dto.DadosDetalhesCliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.usuario.dto.DadosCadastroUsuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<DadosDetalhesCliente> cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dadosCadastro){
        DadosDetalhesCliente cliente = new DadosDetalhesCliente(clienteService.cadastrarCliente(dadosCadastro));

        return ResponseEntity.status(200).body(cliente);
    }

}
