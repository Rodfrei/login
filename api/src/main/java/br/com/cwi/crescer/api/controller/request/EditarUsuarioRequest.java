package br.com.cwi.crescer.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class EditarUsuarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotBlank
    private String fotoPerfil;
}
