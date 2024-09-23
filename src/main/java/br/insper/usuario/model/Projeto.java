package br.insper.usuario.model;

import jakarta.persistence.*;
import lombok.Data;

// import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String cpfGerente;

    @ElementCollection
    private Set<String> membros = new HashSet<>();

    public String getCpfGerente() {
        return cpfGerente;
    }

    public boolean getStatus() {
        return status.equals(Status.ATIVO);
    }

    public <E> List<E> getMembros() {
        return (List<E>) membros;
    }
}


