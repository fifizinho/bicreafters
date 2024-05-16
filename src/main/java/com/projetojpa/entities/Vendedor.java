package com.projetojpa.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table (name = "Vendedor")
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column (name = "meta", nullable = false)
	private double meta;
	
	@NotBlank
	@Column (name = "nome", nullable = false)
	private String nome;
	
	@NotNull
	@Column (name = "salario", nullable = false)
	private double salario;
	
	@NotBlank
	@Column (name = "setor", nullable = false)
	private String setor;
	
	@NotNull
	@Column (name = "totalvendas", nullable = false)
	private double totalvendas;
	
	@ManyToOne
	@JoinColumn(name = "id_Equipe", nullable = false)
	private Equipe equipe;
}

