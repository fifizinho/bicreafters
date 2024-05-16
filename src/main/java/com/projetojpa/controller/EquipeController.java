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

import com.projetojpa.entities.Equipe;
import com.projetojpa.services.EquipeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Equipes", description = "API REST DE GERENCIAMENTO DE Equipes")
@RestController 
@RequestMapping("/equipe") 
public class EquipeController {
	private final EquipeService EquipeService; 

	@Autowired 
	public EquipeController(EquipeService EquipeService) { 
		this.EquipeService = EquipeService; 
	}
	//Query Method
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Localiza Equipe por NOME")
	public ResponseEntity<List<Equipe>> buscarEquipePorNome(@PathVariable  String nome){
		List<Equipe> Equipes = EquipeService.buscarEquipePorNome(nome);
		return ResponseEntity.ok(Equipes);
	}

	//query
	@GetMapping("/cidade/{cidade}")
	@Operation(summary = "Localiza Equipe por CIDADE")
	public List<Equipe> findEquipePorCidade(@PathVariable  String cidade){
		return EquipeService.findByCidade(cidade);
	}

	@GetMapping("/{id}") 
	@Operation(summary = "Localiza Equipe por ID")
	public ResponseEntity<Equipe> buscaEquipeControlId(@PathVariable Long id){ 
		Equipe Equipe = EquipeService.getEquipeById(id); 
		if (Equipe != null) { 
			return ResponseEntity.ok(Equipe); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 

	} 

	@GetMapping("/") 
	 @Operation(summary = "Apresenta todas as Equipes")
	public ResponseEntity<List<Equipe>> buscaTodosEquipesControl(){ 
		List<Equipe> Equipe = EquipeService.getAllEquipe(); 
		return ResponseEntity.ok(Equipe); 
	} 

	@PostMapping("/") 
	 @Operation(summary = "Cadastra uma Equipe")
	public ResponseEntity<Equipe> salvaEquipesControl(@RequestBody @Valid Equipe Equipe){ 
		Equipe salvaEquipe = EquipeService.salvarEquipe(Equipe); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaEquipe); 
	} 

	@PutMapping("/{id}") 
	 @Operation(summary = "Altera a Equipe")
	public ResponseEntity<Equipe> alteraEquipesControl(@PathVariable Long id, @RequestBody @Valid Equipe Equipe){ 
		Equipe alteraEquipe = EquipeService.updateEquipe(id, Equipe); 
		if (alteraEquipe != null) { 
			return ResponseEntity.ok(Equipe); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma Equipe")
	public ResponseEntity<String> apagaEquipeControl(@PathVariable Long id){ 
		boolean apagar = EquipeService.deleteEquipe(id); 
		if(apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 

		else {
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 

