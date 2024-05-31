package com.avaliacao.model;

import com.avaliacao.dtos.AvaliacaoInputDTO;

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
    private Nota nota;
    private String observacao;
    private Long idPedido;


    public void alterar(AvaliacaoInputDTO avaliacaoDto) {
        if (avaliacaoDto.nota() != null) {
            this.nota = avaliacaoDto.nota();
        }
        if (avaliacaoDto.observacao() != null) {
            this.observacao = avaliacaoDto.observacao();
        }
    }


    public Avaliacao(Long idPedido) {
        this.idPedido = idPedido;
    }

}
