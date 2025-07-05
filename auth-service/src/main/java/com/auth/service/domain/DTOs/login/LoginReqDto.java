package com.auth.service.domain.DTOs.login;

import jakarta.validation.constraints.NotBlank;

public record LoginReqDto(
        @NotBlank
        String username,
        @NotBlank
        String password
) {

}
