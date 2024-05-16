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
@Table (name = "Equipe")
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column (name = "cidade", nullable = false)
	private String cidade;
	
	@NotBlank
	@Column (name = "email", nullable = false)
	private String email;
	
	@NotBlank
	@Column (name = "nome", nullable = false)
	private String nome;
	
	@NotNull
	@Column (name = "qtdepessoas", nullable = false)
	private int qtdepessoas;
	
	@NotBlank
	@Column (name = "telefone", nullable = false)
	private String telefone;


}



