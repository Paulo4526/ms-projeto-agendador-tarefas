package com.agendador.agendadortarefas.controller.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowUsuarioDTO {
    private String email;
    private String senha;
}
