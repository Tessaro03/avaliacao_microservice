package com.avaliacao.dtos.avaliacao;

import com.avaliacao.model.Avaliacao;

public record AvaliacaoOutputDTO(

    Long idAvaliacao,
    Long idPedido,
    Long idProduto,
    Double nota,
    String observacao
) {

    public AvaliacaoOutputDTO(Avaliacao avaliacao){
        this(avaliacao.getId(), avaliacao.getIdPedido(), avaliacao.getIdProduto(),avaliacao.getNota(), avaliacao.getObservacao());
    }
}
