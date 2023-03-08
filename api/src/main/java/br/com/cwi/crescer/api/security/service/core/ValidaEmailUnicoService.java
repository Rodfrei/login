package br.com.cwi.crescer.api.security.service.core;

import br.com.cwi.crescer.api.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ValidaEmailUnicoService {
    @Autowired
    UsuarioRepository usuarioRepository;


    public void validar(UsuarioRequest request) {
        if(usuarioRepository.existsByEmail(request.getEmail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já foi cadastrado!!");
        }
    }
}
