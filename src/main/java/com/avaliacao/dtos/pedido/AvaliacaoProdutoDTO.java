package com.avaliacao.dtos.pedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoProdutoDTO(

    @NotNull
    long idProduto,
    
    @NotBlank
    String nome

) {
 
}
