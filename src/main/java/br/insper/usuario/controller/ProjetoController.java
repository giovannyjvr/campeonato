
package br.insper.usuario.controller;

import br.insper.usuario.model.Projeto;
import br.insper.usuario.model.Status;
import br.insper.usuario.service.ProjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
        try {
            return ResponseEntity.ok(projetoService.criarProjeto(projeto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listarProjetos(@RequestParam Optional<Status> status) {
        return ResponseEntity.ok(projetoService.listarProjetos(status));
    }

    @PostMapping("/{id}/adicionar-pessoa")
    public ResponseEntity<Projeto> adicionarPessoa(@PathVariable Long id, @RequestParam String cpf) {
        try {
            return ResponseEntity.ok(projetoService.adicionarPessoa(id, cpf));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
