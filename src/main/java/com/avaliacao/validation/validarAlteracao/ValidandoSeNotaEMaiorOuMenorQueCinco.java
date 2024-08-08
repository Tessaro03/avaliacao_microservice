package com.avaliacao.validation.validarAlteracao;

import org.springframework.stereotype.Service;

import com.avaliacao.dtos.avaliacao.AvaliacaoInputDTO;
import com.avaliacao.infra.exceptions.ValidacaoException;

@Service
public class ValidandoSeNotaEMaiorOuMenorQueCinco implements ValidadorAlteraracao {

    @Override
    public void validar(AvaliacaoInputDTO dto) {
        if (dto.nota() < 0 | dto.nota() > 5) {
            throw new ValidacaoException("Nota deve ser maior que 0 e menor ou igual a 5");
        }
    }
    
}
