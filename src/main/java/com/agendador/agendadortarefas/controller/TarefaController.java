package com.agendador.agendadortarefas.controller;

import com.agendador.agendadortarefas.business.TarefaService;
import com.agendador.agendadortarefas.controller.dto.tarefas.ShowTarefaDTO;
import com.agendador.agendadortarefas.controller.dto.tarefas.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<ShowTarefaDTO> gravarTarefas(@RequestBody TarefasDTO tarefasDTO, @RequestHeader("Authorization") String token){
        ShowTarefaDTO showTarefaDTO = tarefaService.gravarTarefa(tarefasDTO, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(showTarefaDTO);
    }
}
