package com.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.dtos.AvaliacaoInputDTO;
import com.avaliacao.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    
    @Autowired
    private AvaliacaoService service;


    @GetMapping
    public ResponseEntity verAvaliacoes(){
        return ResponseEntity.ok().body(service.verAvaliacoes());
    }

    @PostMapping("/{idPedido}")
    public void criarAvaliacao(@PathVariable Long idPedido){
        service.criarAvaliacao(idPedido);
    }

    @PatchMapping("/{idAvaliacao}")
    public void alterarAvaliacao(@RequestBody AvaliacaoInputDTO dto, @PathVariable long idAvaliacao){
        service.alterarAvaliacao(dto, idAvaliacao);
    }

}
