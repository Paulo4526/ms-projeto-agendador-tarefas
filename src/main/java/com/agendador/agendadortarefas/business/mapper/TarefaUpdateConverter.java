package com.agendador.agendadortarefas.business.mapper;

import com.agendador.agendadortarefas.controller.dto.tarefas.TarefasDTO;
import com.agendador.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

//Classe utilizada para criar um converter que altera somente os valores passados sem ser nulo, caso valor seja nulo irá utilizar os valores não nulos vindos do banco de dados para o objeto
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {
    void updateTarefas(TarefasDTO tarefasDTO, @MappingTarget TarefasEntity tarefasEntity);
}
