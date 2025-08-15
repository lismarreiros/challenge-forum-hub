package com.forumhub.domain.topico;

import com.forumhub.domain.curso.Curso;
import com.forumhub.domain.curso.CursoRepository;
import com.forumhub.domain.usuario.Usuario;
import com.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

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
        // Pega email do usuário logado
        String emailLogado = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario autorLogado = usuarioRepository.findUsuarioByLogin(emailLogado);


        // Busca curso pelo nome
        Curso curso = cursoRepository.findByNome(dados.cursoNome());
//                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        // Cria tópico com autor e curso já definidos
        Topico topico = new Topico(dados, autorLogado, curso);

        return topicoRepository.save(topico);
    }

}
