
package br.insper.usuario.service;

import br.insper.usuario.model.Projeto;
import br.insper.usuario.model.Status;
import br.insper.usuario.repository.ProjetoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    private final ProjetoRepository projetoRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto criarProjeto(Projeto projeto) {
        String url = "http://184.72.80.215:8080/usuario/" + projeto.getCpfGerente();
        Boolean gerenteExiste = restTemplate.getForObject(url, Boolean.class);

        if (gerenteExiste == null || !gerenteExiste) {
            throw new IllegalArgumentException("Gerente não encontrado");
        }

        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjetos(Optional<Status> status) {
        return status.map(projetoRepository::findByStatus).orElse(projetoRepository.findAll());
    }

    public Projeto adicionarPessoa(Long projetoId, String cpfPessoa) {
        String url = "http://184.72.80.215:8080/usuario/" + cpfPessoa;
        Boolean pessoaExiste = restTemplate.getForObject(url, Boolean.class);

        if (pessoaExiste == null || !pessoaExiste) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));

        if (projeto.getStatus() ==  Status.FINALIZADO) {
            throw new IllegalStateException("Não é possível adicionar pessoas a projetos finalizados");
        }

        projeto.getMembros().add(cpfPessoa);
        return projetoRepository.save(projeto);
    }
}
