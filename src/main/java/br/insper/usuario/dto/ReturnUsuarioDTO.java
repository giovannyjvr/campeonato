package br.insper.usuario.dto;

import br.insper.usuario.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnUsuarioDTO {
    private String nome;
    private String cpf;

    public static ReturnUsuarioDTO convert(Usuario usuario) {
        ReturnUsuarioDTO dto = new ReturnUsuarioDTO();
        dto.setCpf(usuario.getCpf());
        dto.setNome(usuario.getNome());
        return dto;
    }

    private void setCpf(Object cpf) {

    }

    private void setNome(Object nome) {

    }
}
