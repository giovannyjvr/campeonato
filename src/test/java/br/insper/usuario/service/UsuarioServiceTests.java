package br.insper.usuario.service;


import br.insper.usuario.dto.ReturnUsuarioDTO;
import br.insper.usuario.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTests {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    public void testListarTimesWhenEstadoIsNull() {

        // preparacao
        Mockito.when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());

        // chamada do codigo testado
        List<ReturnUsuarioDTO> usuarios = usuarioService.getUsers();

        // verificacao dos resultados
        Assertions.assertTrue(usuarios.isEmpty());
    }
}
