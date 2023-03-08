package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.api.security.mapper.UsuarioMapper;
import br.com.cwi.crescer.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarDadosUsuarioService {

    @Autowired
    UsuarioAutenticadoService buscarDadosUsuarioService;

    public UsuarioResponse buscar() {
        return UsuarioMapper.toResponse(buscarDadosUsuarioService.get());
    }
}
