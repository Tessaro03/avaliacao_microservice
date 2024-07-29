package com.avaliacao.service;


import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.dtos.avaliacao.AvaliacaoInputDTO;
import com.avaliacao.dtos.avaliacao.AvaliacaoOutputDTO;
import com.avaliacao.dtos.pedido.AvaliacaoPedidoDTO;
import com.avaliacao.dtos.pedido.AvaliacaoProdutoDTO;
import com.avaliacao.dtos.produto.NotaDTO;
import com.avaliacao.model.Avaliacao;
import com.avaliacao.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void criarAvaliacao(AvaliacaoPedidoDTO dto){
        for (AvaliacaoProdutoDTO avaliacaoProduto : dto.produtos()) {
            var avaliacao = new Avaliacao(avaliacaoProduto,dto.idPedido());
            repository.save(avaliacao);
            
        }
    }

    public void avaliarProduto(AvaliacaoInputDTO dto){
        var avaliacao = repository.findById(dto.idAvaliacao()); 
        if (avaliacao.isPresent()) {
            avaliacao.get().avaliarProduto(dto);
            repository.save(avaliacao.get());
            notaProduto(avaliacao.get());
        }
    }

    public void notaProduto(Avaliacao avaliacao){
        List<Avaliacao> avaliacoes = repository.findAllByIdProduto(avaliacao.getIdProduto());
        double media = avaliacoes.stream().mapToDouble(Avaliacao::getNota).average().orElse(0.0);
        if (media > 5.0) media = 5.0 ;
        rabbitTemplate.convertAndSend("avaliacao.produto",new NotaDTO(avaliacao.getIdProduto(), media));
    }

    public List<AvaliacaoOutputDTO> verAvaliacoes() {
        var avaliacoes = repository.findAll();
        return avaliacoes.stream().map(AvaliacaoOutputDTO::new).toList();
    }


}
