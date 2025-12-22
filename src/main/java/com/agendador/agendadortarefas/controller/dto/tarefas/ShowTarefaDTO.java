package com.agendador.agendadortarefas.controller.dto.tarefas;

import com.agendador.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.agendador.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowTarefaDTO {
    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNotificacaoEnum status;

    public ShowTarefaDTO(TarefasEntity tarefasEntity){
        this(
                tarefasEntity.getId(),
                tarefasEntity.getNomeTarefa(),
                tarefasEntity.getDescricao(),
                tarefasEntity.getDataCriacao(),
                tarefasEntity.getDataEvento(),
                tarefasEntity.getEmailUsuario(),
                tarefasEntity.getDataAlteracao(),
                tarefasEntity.getStatus()
                );
    }
}
