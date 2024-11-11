package br.insper.usuario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.time.LocalDateTime;


@Entity
public class Artigo {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
    private String conteudo;
    private String autor;
    private LocalDateTime dataCriacao;

    // Construtor padrão
    public Artigo() {}

    // Construtor com parâmetros
    public Artigo(String titulo, String conteudo, String autor, LocalDateTime dataCriacao) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
