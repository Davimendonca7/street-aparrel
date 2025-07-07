package com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco;


import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Endereco;

public record AddressResDto(
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep
){
    public AddressResDto(Endereco endereco){
        this(endereco.getRua(), endereco.getNumero(), endereco.getCidade(),
                endereco.getEstado(), endereco.getCep());
    }
}
