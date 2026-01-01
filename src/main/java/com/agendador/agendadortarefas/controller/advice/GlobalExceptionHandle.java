package com.agendador.agendadortarefas.controller.advice;

import com.agendador.agendadortarefas.infrastructure.exceptions.TaskNotFoundException;
import com.agendador.agendadortarefas.infrastructure.exceptions.UnauthorizedException;
import com.agendador.agendadortarefas.infrastructure.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Anotação requerida para ativar o nosso Controller Adivice
@ControllerAdvice
public class GlobalExceptionHandle {

    //Anotação para informar que esse metodo é uma exception global
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleTaskNotFoundException(TaskNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
