package com.breno.crudoptometrista.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name= "pacientes")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(nullable= false)
	private String nome;
	@NotBlank
	@Column(nullable= false,unique= true, length = 14)
	private String cpf;
	@NotNull
	@Min(6)
	private Integer idade;
	@NotBlank
	private String endereco;
	@NotNull
	private Double grauOlhoDireito;
	@NotNull
	private Double grauOlhoEsquerdo;
	private String doenca;
	@NotNull
	@PastOrPresent
	private LocalDate dataConsulta;
	
	public Paciente() {
		super();
	
	}

	public Paciente(Long id, @NotBlank String nome, @NotBlank String cpf, @NotNull @Min(6) Integer idade,
			@NotBlank String endereco, @NotNull Double grauOlhoDireito, @NotNull Double grauOlhoEsquerdo, String doenca,
			@NotNull @PastOrPresent LocalDate dataConsulta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endereco = endereco;
		this.grauOlhoDireito = grauOlhoDireito;
		this.grauOlhoEsquerdo = grauOlhoEsquerdo;
		this.doenca = doenca;
		this.dataConsulta = dataConsulta;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getGrauOlhoDireito() {
		return grauOlhoDireito;
	}

	public void setGrauOlhoDireito(Double grauOlhoDireito) {
		this.grauOlhoDireito = grauOlhoDireito;
	}

	public Double getGrauOlhoEsquerdo() {
		return grauOlhoEsquerdo;
	}

	public void setGrauOlhoEsquerdo(Double grauOlhoEsquerdo) {
		this.grauOlhoEsquerdo = grauOlhoEsquerdo;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
	
}
