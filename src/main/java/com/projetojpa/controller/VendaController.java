package com.projetojpa.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Venda;
import com.projetojpa.services.VendaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Vendas", description = "API REST DE GERENCIAMENTO DE VendaS")
@RestController 
@RequestMapping("/Venda") 
public class VendaController {
	private final VendaService VendaService; 

	@Autowired 
	public VendaController(VendaService VendaService) { 
		this.VendaService = VendaService; 
	}
	//Query Method
	@GetMapping("/data/{data}")
	@Operation(summary = "Localiza Venda por DATA")
	public ResponseEntity<List<Venda>> buscarVendaPorData(@PathVariable  Date data){
		List<Venda> Vendas = VendaService.buscarVendaPorData(data);
		return ResponseEntity.ok(Vendas);
	}

	@GetMapping("/{id}") 
	@Operation(summary = "Localiza Venda por ID")
	public ResponseEntity<Venda> buscaVendaControlId(@PathVariable Long id){ 
		Venda Venda = VendaService.getVendaById(id); 
		if (Venda != null) { 
			return ResponseEntity.ok(Venda); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 

	} 

	@GetMapping("/") 
	 @Operation(summary = "Apresenta todos os Vendas")
	public ResponseEntity<List<Venda>> buscaTodosVendasControl(){ 
		List<Venda> Venda = VendaService.getAllVenda(); 
		return ResponseEntity.ok(Venda); 
	} 

	@PostMapping("/") 
	 @Operation(summary = "Cadastra um Venda")
	public ResponseEntity<Venda> salvaVendasControl(@RequestBody @Valid Venda Venda){ 
		Venda salvaVenda = VendaService.salvarVenda(Venda); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaVenda); 
	} 

	@PutMapping("/{id}") 
	 @Operation(summary = "Altera o Venda")
	public ResponseEntity<Venda> alteraVendasControl(@PathVariable Long id, @RequestBody @Valid Venda Venda){ 
		Venda alteraVenda = VendaService.updateVenda(id, Venda); 
		if (alteraVenda != null) { 
			return ResponseEntity.ok(Venda); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete o Venda")
	public ResponseEntity<String> apagaVendaControl(@PathVariable Long id){ 
		boolean apagar = VendaService.deleteVenda(id); 
		if(apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 

		else {
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 

