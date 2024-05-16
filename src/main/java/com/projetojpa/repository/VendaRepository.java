package com.projetojpa.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import com.projetojpa.entities.Venda;

public interface VendaRepository extends JpaRepository <Venda, Long> {
	
	List<Venda> findByData(@Param("data") Date data);
}
