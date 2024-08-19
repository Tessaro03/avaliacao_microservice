package com.avaliacao.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.dtos.avaliacao.AvaliacaoInputDTO;
import com.avaliacao.validation.validarAlteracao.ValidadorAlteraracao;
import com.avaliacao.validation.validarId.ValidadorId;

@Service
public class ValidadorAvaliacao {

    @Autowired
    private List<ValidadorAlteraracao> validadorAlteraracao;

    @Autowired
    private List<ValidadorId> validadorId;
    
    public void validarAlteracao(AvaliacaoInputDTO dto, Long idCliente){
        validadorId.forEach(v -> v.validar(dto.idAvaliacao(), idCliente));
        validadorAlteraracao.forEach(v -> v.validar(dto));

    }
}
