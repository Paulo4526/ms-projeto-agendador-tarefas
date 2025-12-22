package com.agendador.agendadortarefas.controller;

import com.agendador.agendadortarefas.business.TarefaService;
import com.agendador.agendadortarefas.controller.dto.tarefas.ShowTarefaDTO;
import com.agendador.agendadortarefas.controller.dto.tarefas.TarefasDTO;
import com.agendador.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
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

    @DeleteMapping
    public ResponseEntity<Void> deleteBuId(@RequestParam("id") String id){
        tarefaService.deletaTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/status")
    public ResponseEntity<ShowTarefaDTO> alteraStatusNotificacao(@RequestParam("status")StatusNotificacaoEnum status, @RequestParam("id") String id){
        return ResponseEntity.ok(tarefaService.alteraStatus(status, id));
    }

    @PutMapping("/updateTask")
    public ResponseEntity<ShowTarefaDTO> alteraTarefas(@RequestBody TarefasDTO tarefasDTO, @RequestParam("id") String id){
        return ResponseEntity.ok(tarefaService.updateTarefas(tarefasDTO, id));
    }
}
