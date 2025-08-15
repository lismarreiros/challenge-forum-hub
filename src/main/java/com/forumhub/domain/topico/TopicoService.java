package com.forumhub.domain.topico;

import com.forumhub.domain.curso.Curso;
import com.forumhub.domain.curso.CursoRepository;
import com.forumhub.domain.usuario.Usuario;
import com.forumhub.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico cadastrar(DadosCadastroTopico dados) {
        String emailLogado = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario autorLogado = usuarioRepository.findUsuarioByLogin(emailLogado);
        Curso curso = cursoRepository.findByNome(dados.cursoNome());

        Topico topico = new Topico(dados, autorLogado, curso);

        return topicoRepository.save(topico);
    }

    public void excluir(Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
        }
    }

}
