package br.insper.usuario.repository;

import br.insper.usuario.dto.ReturnUsuarioDTO;
import br.insper.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCpf(String cpf);
}
