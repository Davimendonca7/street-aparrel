package com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente;

import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Cliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco.AddressResDto;

public record ClientResDto(
        String nome,
        String cpf,
        String telefone,
        AddressResDto endereco
) {
    public ClientResDto(Cliente cliente, AddressResDto endereco){
        this(cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), endereco);
    }
}
