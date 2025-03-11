package com.auth.service.domain.DTOs;

import com.auth.service.domain.entity.Usuario;
import com.auth.service.domain.enums.Role;
import lombok.*;

public record UserResDto(
        String login,
        String senha,
        Role role
){
    public UserResDto(Usuario usuario){
        this(usuario.getUsername(), usuario.getPassword(), usuario.getRole());
    }
}