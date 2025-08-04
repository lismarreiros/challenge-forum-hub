package com.forumhub.domain.topico;

import com.forumhub.domain.autor.Autor;
import com.forumhub.domain.curso.Curso;
import com.forumhub.domain.resposta.Resposta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    @Column(name = "datacriacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "curso", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.status = dados.status();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.respostas = new ArrayList<>();
    }
}
