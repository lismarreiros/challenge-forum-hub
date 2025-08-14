package com.forumhub.domain.topico;

import com.forumhub.domain.autor.Autor;
import com.forumhub.domain.autor.AutorRepository;
import com.forumhub.domain.curso.Curso;
import com.forumhub.domain.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico cadastrar(DadosCadastroTopico dados) {
        // Pega email do usuário logado
        String emailLogado = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Autor> autorLogado = autorRepository.findByEmail(emailLogado);


        // Busca curso pelo nome
        Curso curso = cursoRepository.findByNome(dados.cursoNome());
//                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        // Cria tópico com autor e curso já definidos
        Topico topico = new Topico(dados, autorLogado.orElse(null), curso);

        return topicoRepository.save(topico);
    }

}
