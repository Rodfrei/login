package br.com.cwi.crescer.api.security.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;
    private String fotoPerfil;
}
