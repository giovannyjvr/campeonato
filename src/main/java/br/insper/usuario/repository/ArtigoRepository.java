package br.insper.usuario.repository;

import br.insper.usuario.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
    // Não é necessário definir métodos adicionais para CRUD básico.
    // O JpaRepository já fornece métodos como save(), findById(), findAll(), deleteById(), etc.
}
