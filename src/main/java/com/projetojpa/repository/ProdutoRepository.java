package com.projetojpa.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import com.projetojpa.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

	@Query("SELECT a FROM Equipe a WHERE a.nome = nome")
	List<Produto> findByNome(@Param("nome") String nome);
	
	
	List<Produto> findByDescricao(@Param("descricao") String descricao);
}
