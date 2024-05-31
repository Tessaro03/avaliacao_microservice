package com.avaliacao.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.dtos.AvaliacaoInputDTO;
import com.avaliacao.dtos.AvaliacaoOutputDTO;
import com.avaliacao.model.Avaliacao;
import com.avaliacao.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public void criarAvaliacao(Long idPedido){
        var avaliacao = new Avaliacao(idPedido);
        repository.save(avaliacao);
    }

    public void alterarAvaliacao(AvaliacaoInputDTO avaliacaoDto, long idAvaliacao){
        var avaliacao = repository.buscarPorIdPedido(avaliacaoDto.idPedido()); 
        if (avaliacao.isPresent()) {
            avaliacao.get().alterar(avaliacaoDto);
            repository.save(avaliacao.get());
        }
    }

    public List<AvaliacaoOutputDTO> verAvaliacoes() {
        var avaliacoes = repository.findAll();
        return avaliacoes.stream().map(AvaliacaoOutputDTO::new).toList();
    }


}
