
package br.insper.usuario.repository;

import br.insper.usuario.model.Projeto;
import br.insper.usuario.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByStatus(Status status);
}
