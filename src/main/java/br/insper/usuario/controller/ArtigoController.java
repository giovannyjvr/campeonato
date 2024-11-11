package br.insper.usuario.controller;

import br.insper.usuario.dto.ArtigoDTO;
import br.insper.usuario.model.Artigo;
import br.insper.usuario.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    // POST /artigos: Cria um novo artigo (Apenas ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ArtigoDTO> criarArtigo(@RequestBody ArtigoDTO artigoDTO) {
        Artigo artigo = new Artigo(artigoDTO.getTitulo(), artigoDTO.getConteudo(), artigoDTO.getAutor(), null);
        Artigo criado = artigoService.criarArtigo(artigo);
        return new ResponseEntity<>(new ArtigoDTO(criado.getId(), criado.getTitulo(), criado.getConteudo(), criado.getAutor()), HttpStatus.CREATED);
    }

    // DELETE /artigos/{id}: Deleta um artigo existente (Apenas ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarArtigo(@PathVariable Long id) {
        artigoService.deletarArtigo(id);
        return ResponseEntity.noContent().build();
    }

    // GET /artigos: Lista todos os artigos (Acessível por ADMIN e DEVELOPERS)
    @PreAuthorize("hasAnyRole('ADMIN', 'DEVELOPER')")
    @GetMapping
    public ResponseEntity<List<ArtigoDTO>> listarArtigos() {
        List<ArtigoDTO> artigos = artigoService.listarArtigos().stream()
                .map(artigo -> new ArtigoDTO(artigo.getId(), artigo.getTitulo(), artigo.getConteudo(), artigo.getAutor()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(artigos);
    }

    // GET /artigos/{id}: Retorna detalhes de um artigo específico (Acessível por ADMIN e DEVELOPERS)
    @PreAuthorize("hasAnyRole('ADMIN', 'DEVELOPER')")
    @GetMapping("/{id}")
    public ResponseEntity<ArtigoDTO> buscarArtigoPorId(@PathVariable Long id) {
        Optional<Artigo> artigo = artigoService.buscarArtigoPorId(id);
        return artigo.map(value -> ResponseEntity.ok(new ArtigoDTO(value.getId(), value.getTitulo(), value.getConteudo(), value.getAutor())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
