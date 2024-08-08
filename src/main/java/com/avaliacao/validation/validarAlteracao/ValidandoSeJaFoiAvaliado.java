package com.avaliacao.validation.validarAlteracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.dtos.avaliacao.AvaliacaoInputDTO;
import com.avaliacao.infra.exceptions.ValidacaoException;
import com.avaliacao.repository.AvaliacaoRepository;

@Service
public class ValidandoSeJaFoiAvaliado implements ValidadorAlteraracao{

    @Autowired
    private AvaliacaoRepository repository;

    @Override
    public void validar(AvaliacaoInputDTO dto) {
        
        var avaliacao = repository.findById(dto.idAvaliacao());
        if (avaliacao.isPresent()) {
            if (avaliacao.get().getAvaliado()) {
                throw new ValidacaoException("Avaliação já foi avaliada");
            }
        }
    }
    
}
