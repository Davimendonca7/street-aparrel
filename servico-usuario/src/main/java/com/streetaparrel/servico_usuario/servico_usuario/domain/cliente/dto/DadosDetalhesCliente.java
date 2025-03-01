package com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.dto;

import com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDetalhesCliente(
        String nome,
        String cpf,
        String telefone
        //,
    //    String endereco
) {
    public DadosDetalhesCliente (Cliente cliente){
        this(cliente.getNome(), cliente.getCpf(), cliente.getTelefone());
    }
}
