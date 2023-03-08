package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.controller.request.EditarUsuarioRequest;
import br.com.cwi.crescer.api.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.api.service.BuscarDadosUsuarioService;
import br.com.cwi.crescer.api.service.DesabilitarUsuariosService;
import br.com.cwi.crescer.api.service.EditarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.cwi.crescer.api.security.domain.Funcao.Nomes.ADMIN;
import static br.com.cwi.crescer.api.security.domain.Funcao.Nomes.USUARIO;

@RestController
@RequestMapping("/usuario")
public class PerfilController {

    @Autowired
    private EditarUsuarioService editarUsuarioService;

    @Autowired
    private BuscarDadosUsuarioService buscarDadosUsuarioService;

    @Autowired
    private DesabilitarUsuariosService desabilitarUsuariosService;


    @Secured({USUARIO, ADMIN})
    @PutMapping("/editar")
    @ResponseStatus(HttpStatus.OK)
    public void editarUsuarios(@Valid @RequestBody EditarUsuarioRequest request){
        editarUsuarioService.editar(request);
    }

    @Secured({USUARIO, ADMIN})
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse buscarDadosUsuario(){
        return buscarDadosUsuarioService.buscar();
    }

    @Secured(ADMIN)
    @PutMapping("/desabilitar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void desabilitarUsuarios(@PathVariable Long id){
        desabilitarUsuariosService.desabilitar(id);
    }

}
