package br.com.cwi.crescer.api.service;

import br.com.cwi.crescer.api.controller.request.EditarUsuarioRequest;
import br.com.cwi.crescer.api.security.domain.Usuario;
import br.com.cwi.crescer.api.security.repository.UsuarioRepository;
import br.com.cwi.crescer.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class EditarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void editar(EditarUsuarioRequest request) {

        int numero_de_digitos_telefone = 9;
        if(request.getTelefone().replaceAll("[\\D]", "").length() != numero_de_digitos_telefone){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Telefone não é valido.");
        }

        Usuario usuario = usuarioAutenticadoService.get();

        usuario.setNome(request.getNome());
        usuario.setFotoPerfil(request.getFotoPerfil());
        usuario.setTelefone(request.getTelefone());
        usuario.setAtualizadoEm(LocalDate.now());

        usuarioRepository.save(usuario);

    }
}
