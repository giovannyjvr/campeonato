package br.insper.usuario.service;

import br.insper.usuario.dto.CreateUsuarioDTO;
import br.insper.usuario.dto.ReturnUsuarioDTO;
import br.insper.usuario.model.Usuario;
import br.insper.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public ReturnUsuarioDTO createUser(CreateUsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setCpf(dto.getCpf());
        usuario.setNome(dto.getNome());

        return ReturnUsuarioDTO.convert(usuarioRepository.save(usuario));
    }

    public List<ReturnUsuarioDTO> getUsers() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(u -> ReturnUsuarioDTO.convert(u))
                .toList();
    }

    public ReturnUsuarioDTO getUser(String cpf) {
        Usuario usuario = usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException());
        return ReturnUsuarioDTO.convert(usuario);
    }

}
