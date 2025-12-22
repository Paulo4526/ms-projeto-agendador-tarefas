package com.agendador.agendadortarefas.infrastructure.exceptions;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String mensagem){
        super(mensagem);
    }

    public TaskNotFoundException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
