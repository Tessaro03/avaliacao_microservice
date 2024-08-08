package com.avaliacao.validation.validarId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.infra.exceptions.ValidacaoException;
import com.avaliacao.repository.AvaliacaoRepository;

@Service
public class ValidandoSeIdExiste implements ValidadorId {

    @Autowired
    private AvaliacaoRepository repository;

    @Override
    public void validar(Long id) {
        if (!repository.existsById(id)) {
            throw new ValidacaoException("Id não existe");
        }
    }
    
}
