package com.avaliacao.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.service.AvaliacaoService;

@Service
public class AvaliacaoAMQPListener {
    
    @Autowired
    private AvaliacaoService service;

    @RabbitListener(queues = "pagamento.confirmado-avaliacao") 
    public void pagamentoConcluido(Long idPedido) { 
        service.criarAvaliacao(idPedido);
    }

}
