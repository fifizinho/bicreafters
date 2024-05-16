package com.projetojpa.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import com.projetojpa.entities.Vendedor;

public interface VendedorRepository extends JpaRepository <Vendedor, Long> {

	@Query("SELECT a FROM Equipe a WHERE a.nome = nome")
	List<Vendedor> findByNome(@Param("nome") String nome);
	
	
	List<Vendedor> findBySetor(@Param("setor") String setor);
}
