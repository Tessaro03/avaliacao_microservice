package com.avaliacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.avaliacao.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

    @Query("SELECT a FROM Avaliacao a WHERE a.idPedido = :idPedido")
    Optional<Avaliacao> buscarPorIdPedido(Long idPedido);

    @Query("SELECT a FROM Avaliacao a WHERE a.idProduto =:idProduto AND a.avaliado = true")
    public List<Avaliacao> findAllByIdProduto(Long idProduto);

    
    
}
