package com.avaliacao.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.avaliacao.dtos.avaliacao.AvaliacaoInputDTO;
import com.avaliacao.dtos.pedido.AvaliacaoProdutoDTO;
import com.avaliacao.model.Avaliacao;
import com.avaliacao.repository.AvaliacaoRepository;

public class AvaliarProduto {

    @InjectMocks
    private AvaliacaoService service;

    @Mock
    private AvaliacaoRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void avaliarProdutoComNotaEObservacao(){
        AvaliacaoInputDTO avaliacaoInputDTO = new AvaliacaoInputDTO(1L, 2d, "observacao");
        Avaliacao avaliacao = new Avaliacao(new AvaliacaoProdutoDTO(1l, "produto"),1l, 1l);

        service.definirAvalicao(avaliacao,avaliacaoInputDTO);

        assertEquals(2d, avaliacao.getNota());
        assertTrue(avaliacao.getAvaliado());
        assertNotNull(avaliacao.getObservacao());
    }

    @Test
    public void avaliarProdutoComNotaESemObservacao(){
        AvaliacaoInputDTO avaliacaoInputDTO = new AvaliacaoInputDTO(1L, 2d, null);
        Avaliacao avaliacao = new Avaliacao(new AvaliacaoProdutoDTO(1l, "produto"),1l, 1l);

        service.definirAvalicao(avaliacao,avaliacaoInputDTO);

        assertEquals(2d, avaliacao.getNota());
        assertTrue(avaliacao.getAvaliado());
        assertNull(avaliacao.getObservacao());
    }

    @Test
    public void avaliarProdutoSemNotaEComObservacao(){
        AvaliacaoInputDTO avaliacaoInputDTO = new AvaliacaoInputDTO(1L, null, "observacao");
        Avaliacao avaliacao = new Avaliacao(new AvaliacaoProdutoDTO(1l, "produto"),1l, 1l);

        service.definirAvalicao(avaliacao,avaliacaoInputDTO);

        assertNull( avaliacao.getNota());
        assertFalse(avaliacao.getAvaliado());
        assertNull(avaliacao.getObservacao());
    }

    @Test
    public void avaliarProdutoSemNotaESemObservacao(){
        AvaliacaoInputDTO avaliacaoInputDTO = new AvaliacaoInputDTO(1L, null, null);
        Avaliacao avaliacao = new Avaliacao(new AvaliacaoProdutoDTO(1l, "produto"),1l, 1l);

        service.definirAvalicao(avaliacao,avaliacaoInputDTO);

        assertNull( avaliacao.getNota());
        assertFalse(avaliacao.getAvaliado());
        assertNull(avaliacao.getObservacao());
    }
}
