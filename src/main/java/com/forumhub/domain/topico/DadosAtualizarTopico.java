package com.forumhub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
        @NotNull
        Long id,
        String mensagem,
        String titulo
) {
}
