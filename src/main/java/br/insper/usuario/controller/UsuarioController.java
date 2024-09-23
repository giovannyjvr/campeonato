package br.insper.usuario.controller;

import br.insper.usuario.dto.CreateUsuarioDTO;
import br.insper.usuario.dto.ReturnUsuarioDTO;
import br.insper.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<ReturnUsuarioDTO> getUsers() {
        return usuarioService.getUsers();
    }

    @GetMapping("/{cpf}")
    public ReturnUsuarioDTO getUser(@PathVariable String cpf) {
        return usuarioService.getUser(cpf);
    }

    @PostMapping
    public ReturnUsuarioDTO saveUser(@RequestBody CreateUsuarioDTO dto) {
        return usuarioService.createUser(dto);
    }

}
