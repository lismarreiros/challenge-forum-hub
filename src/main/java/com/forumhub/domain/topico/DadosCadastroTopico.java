package com.forumhub.domain.topico;

import com.forumhub.domain.autor.Autor;
import com.forumhub.domain.curso.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        LocalDateTime dataCriacao,

        @NotBlank
        Status status,

        @NotNull
        @Valid
        Autor autor,

        @NotNull
        @Valid
        Curso curso


) {
}
