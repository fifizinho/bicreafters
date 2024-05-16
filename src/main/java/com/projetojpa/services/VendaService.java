package com.projetojpa.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Venda;
import com.projetojpa.repository.VendaRepository;


@Service
public class VendaService {
	
	private final VendaRepository VendaRepository;
	
	@Autowired
	public VendaService (VendaRepository VendaRepository) {
		this.VendaRepository = VendaRepository;
	}
	
		//Query Method
		public List<Venda> buscarVendaPorData(Date data){
			return VendaRepository.findByData(data);
		}
	
	    public List<Venda> getAllVenda() {
	        return VendaRepository.findAll();
	    }

	    public Venda getVendaById(Long id) {
	        Optional<Venda> Venda = VendaRepository.findById(id);
	        return Venda.orElse(null);
	    }

	    public Venda salvarVenda(Venda Venda) {
	        return VendaRepository.save(Venda);
	    }

	    public Venda updateVenda(Long id, Venda updatedVenda) {
	        Optional<Venda> existingVenda = VendaRepository.findById(id);
	        if (existingVenda.isPresent()) {
	            updatedVenda.setId(id);
	            return VendaRepository.save(updatedVenda);
	        }
	        return null;
	    }
	    public boolean deleteVenda(Long id) {
	        Optional<Venda> existingVenda = VendaRepository.findById(id);
	        if (existingVenda.isPresent()) {
	        	VendaRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	}