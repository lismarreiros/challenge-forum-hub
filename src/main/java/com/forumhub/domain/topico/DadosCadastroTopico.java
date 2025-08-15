package com.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        @NotBlank(message = "O título não pode ser nulo")
        String titulo,

        @NotBlank(message = "A mensagem não pode ser nula")
        String mensagem,

        @NotBlank(message = "O nome do curso não pode ser nulo")
        String cursoNome

) {
}
