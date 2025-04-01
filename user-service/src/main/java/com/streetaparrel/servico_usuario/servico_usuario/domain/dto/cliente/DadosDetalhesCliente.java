package com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente;

import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Cliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco.EnderecoResDto;

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
