package com.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.dtos.avaliacao.AvaliacaoInputDTO;
import com.avaliacao.service.AvaliacaoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;

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


    @PatchMapping()
    @Operation(summary = "Avaliar Produto")
    public void avaliarProduto(@RequestBody AvaliacaoInputDTO dto, HttpServletRequest request){
        service.avaliarProduto(dto, request);
    }

}
