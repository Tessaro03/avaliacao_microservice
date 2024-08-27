package com.avaliacao.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.avaliacao.dtos.avaliacao.AvaliacaoInputDTO;
import com.avaliacao.dtos.pedido.AvaliacaoProdutoDTO;
import com.avaliacao.model.Avaliacao;
import com.avaliacao.repository.AvaliacaoRepository;

public class NotaProduto {

    @InjectMocks
    private AvaliacaoService service;

    @Mock
    private AvaliacaoRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void notaProdutoCom2AvaliacoesIgual(){
        Avaliacao avaliacao1 = new Avaliacao(new AvaliacaoProdutoDTO(1l, "sushi"), 1l, 1l);
        Avaliacao avaliacao2 = new Avaliacao(new AvaliacaoProdutoDTO(1l, "sushi"), 2l, 2l);

        AvaliacaoInputDTO avaliacaoInputDTO1 = new AvaliacaoInputDTO(1l, 3d, "observacao");
        AvaliacaoInputDTO avaliacaoInputDTO2 = new AvaliacaoInputDTO(2l, 3d, "observacao");

        service.definirAvalicao(avaliacao1,avaliacaoInputDTO1);
        service.definirAvalicao(avaliacao2,avaliacaoInputDTO2);

        List<Avaliacao> avaliacoes = new ArrayList<>();
        avaliacoes.add(avaliacao1);
        avaliacoes.add(avaliacao2);


       given(repository.findAllByIdProduto(avaliacao1.getId())).willReturn(avaliacoes);

       assertEquals( avaliacoes.stream().mapToDouble(Avaliacao::getNota).average().orElse(0.0), 3d);

    }

    @Test
    public void notaProdutoCom2AvaliacoesDiferente(){
        Avaliacao avaliacao1 = new Avaliacao(new AvaliacaoProdutoDTO(1l, "sushi"), 1l, 1l);
        Avaliacao avaliacao2 = new Avaliacao(new AvaliacaoProdutoDTO(1l, "sushi"), 2l, 2l);

        AvaliacaoInputDTO avaliacaoInputDTO1 = new AvaliacaoInputDTO(1l, 2.5, "observacao");
        AvaliacaoInputDTO avaliacaoInputDTO2 = new AvaliacaoInputDTO(2l, 4.5, "observacao");

        service.definirAvalicao(avaliacao1,avaliacaoInputDTO1);
        service.definirAvalicao(avaliacao2,avaliacaoInputDTO2);

        List<Avaliacao> avaliacoes = new ArrayList<>();
        avaliacoes.add(avaliacao1);
        avaliacoes.add(avaliacao2);


       given(repository.findAllByIdProduto(avaliacao1.getId())).willReturn(avaliacoes);

       assertEquals( avaliacoes.stream().mapToDouble(Avaliacao::getNota).average().orElse(0.0), 3.5);

    }
    

}
