package br.com.cwi.crescer.api.security.service;

import br.com.cwi.crescer.api.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.api.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.api.security.domain.Permissao;
import br.com.cwi.crescer.api.security.domain.Usuario;
import br.com.cwi.crescer.api.security.repository.UsuarioRepository;
import br.com.cwi.crescer.api.security.service.core.ValidaEmailUnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static br.com.cwi.crescer.api.security.domain.Funcao.USUARIO;
import static br.com.cwi.crescer.api.security.mapper.UsuarioMapper.toEntity;
import static br.com.cwi.crescer.api.security.mapper.UsuarioMapper.toResponse;

@Service
public class IncluirUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ValidaEmailUnicoService validaEmailUnicoService;

    public UsuarioResponse incluir(UsuarioRequest request) {

        validaEmailUnicoService.validar(request);

        int numero_de_digitos_telefone = 9;
        if(request.getTelefone().replaceAll("[\\D]", "").length() != numero_de_digitos_telefone){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Telefone não é valido.");
        }



        Usuario usuario = toEntity(request);
        usuario.setSenha(getSenhaCriptografada(request.getSenha()));
        usuario.adicionarPermissao(getPermissaoPadrao());
        usuario.setCriadoEm(LocalDate.now());
        usuario.setAtualizadoEm(LocalDate.now());

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }

    private String getSenhaCriptografada(String senhaAberta) {
        return passwordEncoder.encode(senhaAberta);
    }

    private Permissao getPermissaoPadrao() {
        Permissao permissao = new Permissao();
        permissao.setFuncao(USUARIO);
        return permissao;
    }
}
