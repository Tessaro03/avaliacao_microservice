package com.avaliacao.dtos;

import com.avaliacao.model.Nota;

public record AvaliacaoInputDTO(
    
    Long idPedido,
    String observacao,
    Nota nota

) {
}
