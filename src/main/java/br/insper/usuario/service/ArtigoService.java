package br.insper.usuario.service;

import br.insper.usuario.model.Artigo;
import br.insper.usuario.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    // Método para criar um novo artigo
    public Artigo criarArtigo(Artigo artigo) {
        artigo.setDataCriacao(LocalDateTime.now());
        return artigoRepository.save(artigo);
    }

    // Método para listar todos os artigos
    public List<Artigo> listarArtigos() {
        return artigoRepository.findAll();
    }

    // Método para buscar um artigo pelo ID
    public Optional<Artigo> buscarArtigoPorId(Long id) {
        return artigoRepository.findById(id);
    }

    // Método para deletar um artigo pelo ID
    public void deletarArtigo(Long id) {
        if (artigoRepository.existsById(id)) {
            artigoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Artigo não encontrado");
        }
    }
}
