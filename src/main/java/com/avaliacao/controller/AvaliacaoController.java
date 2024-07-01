package com.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.dtos.AvaliacaoInputDTO;
import com.avaliacao.service.AvaliacaoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    
    @Autowired
    private AvaliacaoService service;


    @GetMapping
    @Operation(summary = "Ver Avaliações", description = "Retorna as avaliações criada")
    public ResponseEntity verAvaliacoes(){
        return ResponseEntity.ok().body(service.verAvaliacoes());
    }


    @PatchMapping("/{idAvaliacao}")
    @Operation(summary = "Alterar Avaliação", description = "Alterar valores da avaliação")
    public void alterarAvaliacao(@RequestBody AvaliacaoInputDTO dto, @PathVariable long idAvaliacao){
        service.alterarAvaliacao(dto, idAvaliacao);
    }

}
