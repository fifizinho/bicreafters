package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column (name = "descricao", nullable = false)
	private String descricao;
	
	@NotBlank
	@Column (name = "nome", nullable = false)
	private String nome;
	
	@NotNull
	@Column (name = "preco", nullable = false)
	private double preco;
	
	@NotBlank
	@Column (name = "qtde", nullable = false)
	private String qtde;
}



