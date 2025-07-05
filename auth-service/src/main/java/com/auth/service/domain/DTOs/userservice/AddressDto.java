package com.auth.service.domain.DTOs.userservice;

public record AddressDto(
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep
) {
}
