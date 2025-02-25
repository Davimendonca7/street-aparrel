package com.streetaparrel.servico_usuario.servico_usuario.infra.exception;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}

