package com.avaliacao.dtos.pedido;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


 public record AvaliacaoPedidoDTO(
    
   @NotNull
   Long idPedido,
   
   @NotEmpty
   List<AvaliacaoProdutoDTO> produtos


) {
}
