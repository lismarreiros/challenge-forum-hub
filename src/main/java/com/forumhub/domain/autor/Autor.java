package com.forumhub.domain.autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Autor")
@Table(name = "usuarios")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Autor(DadosAutor dados){
        this.nome = dados.nome();
        this.email = dados.email();
    }
}