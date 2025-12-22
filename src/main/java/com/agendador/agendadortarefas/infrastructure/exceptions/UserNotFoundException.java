package com.agendador.agendadortarefas.infrastructure.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mensagem){
        super(mensagem);
    }

    public UserNotFoundException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
