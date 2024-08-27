package com.avaliacao.dtos.avaliacao;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoInputDTO(

    @NotNull
    Long idAvaliacao,

    @NotNull
    @Min(0)
    @Max(5)
    Double nota,
    
    String observacao

) {
    
}
