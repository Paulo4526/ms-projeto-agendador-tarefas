package com.agendador.agendadortarefas.business;

import com.agendador.agendadortarefas.business.mapper.TarefaConverter;
import com.agendador.agendadortarefas.controller.dto.tarefas.ShowTarefaDTO;
import com.agendador.agendadortarefas.controller.dto.tarefas.TarefasDTO;
import com.agendador.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.agendador.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.agendador.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.agendador.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    //Metodo que irá gravar uma nova tarefa no MongoDB
    public ShowTarefaDTO gravarTarefa(TarefasDTO tarefasDTO, String token){
        //Recebendo token e retirando o e-mail pelo metodo no jwtutil
        String email = jwtUtil.extractUsername(token.substring(7));
        //Setando o email recebido no token
        tarefasDTO.setEmailUsuario(email);
        //Setando a data e hora da criação
        tarefasDTO.setDataCriacao(LocalDateTime.now());
        //Setando o status do agendador
        tarefasDTO.setStatus(StatusNotificacaoEnum.PENDENTE);
        //Salvando os valores recebidos da requisição e convertidos na entidade TarefasEntity
        TarefasEntity tarefasEntity = tarefaConverter.paraTarefaEntity(tarefasDTO, token);
        //Recebendo os valores da entity e salvando no banco de dados, retornando somente os dados que o ShowDTO informar
        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(tarefasEntity));
    }

    //Metodo que retorna uma lista de tarefas entre datas
    public List<ShowTarefaDTO> buscarTarefasAgendadas(LocalDateTime dataEventoInicio, LocalDateTime dataEventoFinal){
        //Retornando uma lista de Tarefas utilizando o converter, aqui ainda não estamos utilizando o converter.
        return tarefaConverter.paraListaTarefaDTO(tarefasRepository.findByDataEventoBetween(dataEventoInicio, dataEventoFinal));
    }

    //Metodo que busca tarefas pelo email
    public List<ShowTarefaDTO> buscarTarefasPeloEmail(String token){
        //Recebe somente o token, de onde será extraido o email de usuário para realizar a busca
        String email = jwtUtil.extractUsername(token.substring(7));
        //Salva os resultados da busca na entidade
        List<TarefasEntity> listaTerefas = tarefasRepository.findByEmailUsuario(email);
        //Retorna a lista de tarefas buscada por email
        return tarefaConverter.paraListaTarefaDTO(listaTerefas);
    }
}
