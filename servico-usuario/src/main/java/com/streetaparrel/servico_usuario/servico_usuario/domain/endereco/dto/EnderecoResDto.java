package com.streetaparrel.servico_usuario.servico_usuario.domain.endereco.dto;


import com.streetaparrel.servico_usuario.servico_usuario.domain.endereco.Endereco;

public record EnderecoResDto (
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep
){
    public EnderecoResDto(Endereco endereco){
        this(endereco.getRua(), endereco.getNumero(), endereco.getCidade(),
                endereco.getEstado(), endereco.getCep());
    }
}
