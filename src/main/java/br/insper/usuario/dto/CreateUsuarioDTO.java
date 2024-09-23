package br.insper.usuario.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUsuarioDTO {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String cpf;

    public Object getNome() {
        return null;
    }

    public Object getCpf() {
        return null;
    }
}
