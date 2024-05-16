package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.repository.VendedorRepository;
import com.projetojpa.entities.Vendedor;


@Service
public class VendedorService {
	
	private final VendedorRepository VendedorRepository;
	
	@Autowired
	public VendedorService (VendedorRepository VendedorRepository) {
		this.VendedorRepository = VendedorRepository;
	}
	
		//Query Method
		public List<Vendedor> buscarVendedorPorSetor(String setor){
			return VendedorRepository.findBySetor(setor);
		}
		//query 
		public List<Vendedor> findByNome(String nome){
			return VendedorRepository.findByNome(nome);
		}
	
	    public List<Vendedor> getAllVendedor() {
	        return VendedorRepository.findAll();
	    }

	    public Vendedor getVendedorById(Long id) {
	        Optional<Vendedor> Vendedor = VendedorRepository.findById(id);
	        return Vendedor.orElse(null);
	    }

	    public Vendedor salvarVendedor(Vendedor Vendedor) {
	        return VendedorRepository.save(Vendedor);
	    }

	    public Vendedor updateVendedor(Long id, Vendedor updatedVendedor) {
	        Optional<Vendedor> existingVendedor = VendedorRepository.findById(id);
	        if (existingVendedor.isPresent()) {
	            updatedVendedor.setId(id);
	            return VendedorRepository.save(updatedVendedor);
	        }
	        return null;
	    }
	    public boolean deleteVendedor(Long id) {
	        Optional<Vendedor> existingVendedor = VendedorRepository.findById(id);
	        if (existingVendedor.isPresent()) {
	        	VendedorRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	}