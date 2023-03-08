package br.com.cwi.crescer.api.security.repository;

import br.com.cwi.crescer.api.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByNomeContainsIgnoreCaseOrEmailContainsIgnoreCase(String nome, String email);

    boolean existsByEmail(String email);
}
