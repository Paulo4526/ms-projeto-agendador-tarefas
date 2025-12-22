package com.agendador.agendadortarefas.controller;

import com.agendador.agendadortarefas.business.TarefaService;
import com.agendador.agendadortarefas.controller.dto.tarefas.ShowTarefaDTO;
import com.agendador.agendadortarefas.controller.dto.tarefas.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/eventos")
    public ResponseEntity<List<ShowTarefaDTO>> listarTarefasEntreDatas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataEventoInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataEventoFinal){
        return ResponseEntity.ok(tarefaService.buscarTarefasAgendadas(dataEventoInicio, dataEventoFinal));
    }

    @GetMapping
    public ResponseEntity<List<ShowTarefaDTO>> buscarTarefasPeloEmail (@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefaService.buscarTarefasPeloEmail(token));
    }
}
