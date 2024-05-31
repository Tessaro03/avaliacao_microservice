package com.avaliacao.dtos;

import com.avaliacao.model.Avaliacao;
import com.avaliacao.model.Nota;

public record AvaliacaoOutputDTO(

    Long idAvaliacao,
    Long idPedido,
    Nota nota,
    String observacao
) {

    public AvaliacaoOutputDTO(Avaliacao avaliacao){
        this(avaliacao.getId(), avaliacao.getIdPedido(), avaliacao.getNota(), avaliacao.getObservacao());
    }
}
