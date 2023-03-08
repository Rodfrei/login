package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.security.domain.Usuario;
import br.com.cwi.crescer.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DesabilitarUsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void desabilitar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado."));
        if(!usuario.isAtivo()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario já foi desabilitado.");
        }
        usuario.setAtivo(false);

        usuarioRepository.save(usuario);
    }
}
