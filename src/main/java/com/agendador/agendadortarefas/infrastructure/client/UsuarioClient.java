package com.agendador.agendadortarefas.infrastructure.client;

import com.agendador.agendadortarefas.controller.DTO.ShowUsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

//Declarando a variavel para o FeignCliente, passando o nome da API que será consumida e a url da requisição
//A variavel usuario.url, é a url de chamado para a api usuario criado anteriormente, a mesma está em aplication.properties
@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {
    //Fazendo a requisição, apontando para o MS-USUARIO buscando usuario por e-mail, também é necessário passar o token para o metodo
    @GetMapping
    ShowUsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email, @RequestHeader("Authorization") String token);
}
