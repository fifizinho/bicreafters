package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.repository.EquipeRepository;
import com.projetojpa.entities.Equipe;


@Service
public class EquipeService {
	
	private final EquipeRepository EquipeRepository;
	
	@Autowired
	public EquipeService (EquipeRepository EquipeRepository) {
		this.EquipeRepository = EquipeRepository;
	}
	
		//Query Method
		public List<Equipe> buscarEquipePorNome(String nome){
			return EquipeRepository.findByNome(nome);
		}
		//query 
		public List<Equipe> findByCidade(String cidade){
			return EquipeRepository.findByCidade(cidade);
		}
	
	    public List<Equipe> getAllEquipe() {
	        return EquipeRepository.findAll();
	    }

	    public Equipe getEquipeById(Long id) {
	        Optional<Equipe> Equipe = EquipeRepository.findById(id);
	        return Equipe.orElse(null);
	    }

	    public Equipe salvarEquipe(Equipe Equipe) {
	        return EquipeRepository.save(Equipe);
	    }

	    public Equipe updateEquipe(Long id, Equipe updatedEquipe) {
	        Optional<Equipe> existingEquipe = EquipeRepository.findById(id);
	        if (existingEquipe.isPresent()) {
	            updatedEquipe.setId(id);
	            return EquipeRepository.save(updatedEquipe);
	        }
	        return null;
	    }
	    public boolean deleteEquipe(Long id) {
	        Optional<Equipe> existingEquipe = EquipeRepository.findById(id);
	        if (existingEquipe.isPresent()) {
	        	EquipeRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	}