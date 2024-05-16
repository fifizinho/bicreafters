package com.projetojpa.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.projetojpa.entities.Equipe;

public interface EquipeRepository extends JpaRepository <Equipe, Long>{
	
	
	List<Equipe> findByNome(@Param("nome") String nome);
	
	@Query("SELECT a FROM Equipe a WHERE a.cidade LIKE = cidade")
	List<Equipe> findByCidade(@Param("cidade") String cidade);
	
	

}
