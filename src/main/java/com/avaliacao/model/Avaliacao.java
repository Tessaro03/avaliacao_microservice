package com.avaliacao.model;

import java.time.LocalDateTime;

import com.avaliacao.dtos.avaliacao.AvaliacaoInputDTO;
import com.avaliacao.dtos.pedido.AvaliacaoProdutoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "avaliacao")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Avaliacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idPedido;
    private Long idProduto;
    private Long idCliente;
    private LocalDateTime dataCriacao;
    private String nomeProduto;


    private Double nota;
    private String observacao;
    private Boolean avaliado;

    public Avaliacao(AvaliacaoProdutoDTO dto, Long idPedido, long idCliente) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idProduto = dto.idProduto();
        this.nomeProduto = dto.nome();
        this.dataCriacao = LocalDateTime.now();
        this.avaliado = false;
        
    }




}
