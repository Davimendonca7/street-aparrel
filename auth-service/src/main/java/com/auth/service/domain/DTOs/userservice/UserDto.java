package com.auth.service.domain.DTOs.userservice;

public record UserDto(
        String nome,
        String cpf,
        String telefone,
        AddressDto endereco
) {
//    public ClientResDto(Cliente cliente, AddressResDto endereco){
//        this(cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), endereco);
//    }
}