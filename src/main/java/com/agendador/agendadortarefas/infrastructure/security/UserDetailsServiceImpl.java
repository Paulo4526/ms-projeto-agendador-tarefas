package com.agendador.agendadortarefas.infrastructure.security;

import com.agendador.agendadortarefas.controller.dto.usuario.ShowUsuarioDTO;
import com.agendador.agendadortarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {
    @Autowired
    private UsuarioClient client;

    //Criando metodo proprio para receber o email e token e validar o acesso
    public UserDetails loadUserData(String email, String token){
        ShowUsuarioDTO showUsuarioDTO = client.buscaUsuarioPorEmail(email, token);
        return User
                .withUsername(showUsuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(showUsuarioDTO.getSenha()) // Define a senha do usuário
                .build();
    }
}