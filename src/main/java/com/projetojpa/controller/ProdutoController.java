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

import com.projetojpa.entities.Produto;
import com.projetojpa.services.ProdutoService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Produtos", description = "API REST DE GERENCIAMENTO DE PRODUTOS")
@RestController 
@RequestMapping("/produto") 
public class ProdutoController {
	private final ProdutoService ProdutoService; 

	@Autowired 
	public ProdutoController(ProdutoService ProdutoService) { 
		this.ProdutoService = ProdutoService; 
	}
	//Query Method
	@GetMapping("/descricao/{descricao}")
	@Operation(summary = "Localiza produto por DESCRICAO")
	public ResponseEntity<List<Produto>> buscarProdutoPorDescricao(@PathVariable  String descricao){
		List<Produto> Produtos = ProdutoService.buscarProdutoPorDescricao(descricao);
		return ResponseEntity.ok(Produtos);
	}

	//query
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Localiza produto por NOME")
	public List<Produto> findProdutoPorNome(@PathVariable  String nome){
		return ProdutoService.findByNome(nome);
	}

	@GetMapping("/{id}") 
	@Operation(summary = "Localiza produto por ID")
	public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable Long id){ 
		Produto Produto = ProdutoService.getProdutoById(id); 
		if (Produto != null) { 
			return ResponseEntity.ok(Produto); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 

	} 

	@GetMapping("/") 
	 @Operation(summary = "Apresenta todos os Produtos")
	public ResponseEntity<List<Produto>> buscaTodosProdutosControl(){ 
		List<Produto> Produto = ProdutoService.getAllProduto(); 
		return ResponseEntity.ok(Produto); 
	} 

	@PostMapping("/") 
	 @Operation(summary = "Cadastra um produto")
	public ResponseEntity<Produto> salvaProdutosControl(@RequestBody @Valid Produto Produto){ 
		Produto salvaProduto = ProdutoService.salvarProduto(Produto); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto); 
	} 

	@PutMapping("/{id}") 
	 @Operation(summary = "Altera o produto")
	public ResponseEntity<Produto> alteraProdutosControl(@PathVariable Long id, @RequestBody @Valid Produto Produto){ 
		Produto alteraProduto = ProdutoService.updateProduto(id, Produto); 
		if (alteraProduto != null) { 
			return ResponseEntity.ok(Produto); 
		} 

		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete o produto")
	public ResponseEntity<String> apagaProdutoControl(@PathVariable Long id){ 
		boolean apagar = ProdutoService.deleteProduto(id); 
		if(apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 

		else {
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 

