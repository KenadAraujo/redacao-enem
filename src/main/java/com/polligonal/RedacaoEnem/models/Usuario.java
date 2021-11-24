package com.polligonal.RedacaoEnem.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -3586512831466688169L;
	
	private Long id;
	private String nome;
	private String senha;
	private Date dataCriacao;
	private Date ultimoAcesso;
	
	private Set<Perfil> perfis;
}