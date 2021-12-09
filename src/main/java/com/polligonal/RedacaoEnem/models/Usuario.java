package com.polligonal.RedacaoEnem.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -3586512831466688169L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String senha;
	private Date dataCriacao;
	private Date ultimoAcesso;
	
	@ManyToMany
	@JoinTable(name = "usuario_perfil",
	    joinColumns = { @JoinColumn(name = "usuario_id") },
	    inverseJoinColumns = { @JoinColumn(name = "perfil_id") })
	private Set<Perfil> perfis;
}