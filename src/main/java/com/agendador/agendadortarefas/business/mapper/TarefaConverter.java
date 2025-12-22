package com.agendador.agendadortarefas.business.mapper;

import com.agendador.agendadortarefas.controller.dto.tarefas.ShowTarefaDTO;
import com.agendador.agendadortarefas.controller.dto.tarefas.TarefasDTO;
import com.agendador.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaConverter {
    //Ao invés de criar os metodos como no projeto usuario, aqui utilziamos o mapper que fará a conversao dos dados
    //Metodo que salvará os dados Recebidos da requisição e fará a equiparação para a entity
    TarefasEntity paraTarefaEntity(TarefasDTO dto, String token);
    //Metodo que retorna os dados em Show DTO com base no dados da Tarefas Entity
    ShowTarefaDTO paraTarefaDTO(TarefasEntity tarefasEntity);
    //Metodo que converta uma lista de dados para o DTO
    List<ShowTarefaDTO> paraListaTarefaDTO(List<TarefasEntity> tarefasEntities);
}
