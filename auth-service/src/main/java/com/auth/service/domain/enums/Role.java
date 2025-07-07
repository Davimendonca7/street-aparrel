package com.auth.service.domain.enums;

public enum Role {
    USER,
    ADMIN;

    public Role verificar(String roleString){
       return Role.valueOf(roleString);
    }
}
