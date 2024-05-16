package com.projetojpa.controller;

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

import com.projetojpa.entities.Vendedor;
import com.projetojpa.services.VendedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Vendedores", description = "API REST DE GERENCIAMENTO DE Vendedores")
@RestController 
@RequestMapping("/vendedor") 
public class VendedorController {
	private final VendedorService VendedorService; 

	@Autowired 
	public VendedorController(VendedorService VendedorService) { 
		this.VendedorService = VendedorService; 
	}
	//Query Method
	@GetMapping("/setor/{setor}")
	@Operation(summary = "Localiza Vendedor por SETOR")
	public ResponseEntity<List<Vendedor>> buscarVendedorPorSetor(@PathVariable  String setor){
		List<Vendedor> Vendedor = VendedorService.buscarVendedorPorSetor(setor);
		return ResponseEntity.ok(Vendedor);
	}


	
	//query
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Localiza Vendedor por NOME")
	public List<Vendedor> findVendedorPorNome(@PathVariable  String nome){
		return VendedorService.findByNome(nome);
	}

	@GetMapping("/{id}") 
	@Operation(summary = "Localiza Vendedor por ID")
	public ResponseEntity<Vendedor> buscaVendedorControlId(@PathVariable Long id){ 
		Vendedor Vendedor = VendedorService.getVendedorById(id); 
		if (Vendedor != null) { 
			return ResponseEntity.ok(Vendedor); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 

	} 

	@GetMapping("/") 
	 @Operation(summary = "Apresenta todos os Vendedors")
	public ResponseEntity<List<Vendedor>> buscaTodosVendedorsControl(){ 
		List<Vendedor> Vendedor = VendedorService.getAllVendedor(); 
		return ResponseEntity.ok(Vendedor); 
	} 

	@PostMapping("/") 
	 @Operation(summary = "Cadastra um Vendedor")
	public ResponseEntity<Vendedor> salvaVendedorsControl(@RequestBody @Valid Vendedor Vendedor){ 
		Vendedor salvaVendedor = VendedorService.salvarVendedor(Vendedor); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaVendedor); 
	} 

	@PutMapping("/{id}") 
	 @Operation(summary = "Altera o Vendedor")
	public ResponseEntity<Vendedor> alteraVendedorsControl(@PathVariable Long id, @RequestBody @Valid Vendedor Vendedor){ 
		Vendedor alteraVendedor = VendedorService.updateVendedor(id, Vendedor); 
		if (alteraVendedor != null) { 
			return ResponseEntity.ok(Vendedor); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete o Vendedor")
	public ResponseEntity<String> apagaVendedorControl(@PathVariable Long id){ 
		boolean apagar = VendedorService.deleteVendedor(id); 
		if(apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 

		else {
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 

