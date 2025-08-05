package com.forumhub.domain.topico;

import com.forumhub.domain.resposta.Resposta;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalhamentoTopico(Long id,
                                      String titulo,
                                      String mensagem,
                                      LocalDateTime dataCriacao,
                                      String autor,
                                      Status status
                                      ) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor().getNome(), topico.getStatus());
    }
}
