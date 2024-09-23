package br.insper.usuario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String cpf;

    public void setNome(Object nome) {

    }

    public Object getCpf() {

        return null;
    }

    public void setCpf(Object cpf) {
    }

    public Object getNome() {
        return null;
    }
}