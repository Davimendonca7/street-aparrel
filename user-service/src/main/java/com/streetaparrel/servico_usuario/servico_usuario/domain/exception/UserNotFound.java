package com.streetaparrel.servico_usuario.servico_usuario.domain.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
}
