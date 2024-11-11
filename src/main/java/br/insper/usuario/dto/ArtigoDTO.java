package br.insper.usuario.dto;

public class ArtigoDTO {

    private Long id;
    private String titulo;
    private String conteudo;
    private String autor;

    // Construtor padrão
    public ArtigoDTO() {}

    // Construtor com parâmetros
    public ArtigoDTO(Long id, String titulo, String conteudo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
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
}
