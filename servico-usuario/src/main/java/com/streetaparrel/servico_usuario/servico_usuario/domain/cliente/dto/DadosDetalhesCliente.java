package com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.dto;

import com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.Cliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.endereco.dto.EnderecoResDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDetalhesCliente(
        String nome,
        String cpf,
        String telefone,
        EnderecoResDto endereco
) {
    public DadosDetalhesCliente (Cliente cliente, EnderecoResDto endereco){
        this(cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), endereco);
    }
}
