package com.fiap.shift.aluno.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="aluno")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Aluno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7965594663656290979L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
    private String name;
	
	 //@Column(name="nascimento")
    private String nascimento;
    
    //@Column(name="cidade")
    private String cidade;
    
    //@Column(name="estado")
    private String estado;
    
    //@Column(name="nivelEducacional")
    private String nivelEducacional;
    
    //@Column(name="profissao")
    private String profissao;
    
    //@Column(name="cartaoCredito")
    private String cartaoCredito;
	    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNivelEducacional() {
		return nivelEducacional;
	}

	public void setNivelEducacional(String nivelEducacional) {
		this.nivelEducacional = nivelEducacional;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
	
	

}
