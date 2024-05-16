package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.repository.ProdutoRepository;
import com.projetojpa.entities.Produto;


@Service
public class ProdutoService {
	
	private final ProdutoRepository ProdutoRepository;
	
	@Autowired
	public ProdutoService (ProdutoRepository ProdutoRepository) {
		this.ProdutoRepository = ProdutoRepository;
	}
	
		//Query Method
		public List<Produto> buscarProdutoPorDescricao(String descricao){
			return ProdutoRepository.findByDescricao(descricao);
		}
		//query 
		public List<Produto> findByNome(String nome){
			return ProdutoRepository.findByNome(nome);
		}
	
	    public List<Produto> getAllProduto() {
	        return ProdutoRepository.findAll();
	    }

	    public Produto getProdutoById(Long id) {
	        Optional<Produto> Produto = ProdutoRepository.findById(id);
	        return Produto.orElse(null);
	    }

	    public Produto salvarProduto(Produto Produto) {
	        return ProdutoRepository.save(Produto);
	    }

	    public Produto updateProduto(Long id, Produto updatedProduto) {
	        Optional<Produto> existingProduto = ProdutoRepository.findById(id);
	        if (existingProduto.isPresent()) {
	            updatedProduto.setId(id);
	            return ProdutoRepository.save(updatedProduto);
	        }
	        return null;
	    }
	    public boolean deleteProduto(Long id) {
	        Optional<Produto> existingProduto = ProdutoRepository.findById(id);
	        if (existingProduto.isPresent()) {
	        	ProdutoRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	}