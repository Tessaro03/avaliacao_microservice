package com.avaliacao.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.dtos.pedido.AvaliacaoPedidoDTO;
import com.avaliacao.service.AvaliacaoService;

@Service
public class AvaliacaoAMQPListener {
    
    @Autowired
    private AvaliacaoService service;
 
    @RabbitListener(queues = "pedido.entregue") 
    public void pedidoEntregue(AvaliacaoPedidoDTO dto) { 
        service.criarAvaliacao(dto);
    }
}
