package com.avaliacao.validation.validarId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.infra.exceptions.ValidacaoException;
import com.avaliacao.repository.AvaliacaoRepository;

@Service
public class ValidandoSeAvaliacaoEDoCliente implements  ValidadorId{


    @Autowired
    private AvaliacaoRepository repository;

    @Override
    public void validar(Long id, Long idCliente) {
        var avaliacao = repository.findById(id);
        if (avaliacao.isPresent() && !avaliacao.get().getIdCliente().equals(idCliente)) {
            throw new ValidacaoException("Avaliação não pertence a esse usuário");
        }
    }
    
}
