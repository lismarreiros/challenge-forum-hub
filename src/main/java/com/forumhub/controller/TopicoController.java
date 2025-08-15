package com.forumhub.controller;

import com.forumhub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
       Topico topico = topicoService.cadastrar(dados);
       repository.save(topico);

       var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
       return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }
}
