package com.polligonal.RedacaoEnem.models;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class Perfil implements Serializable{

	private static final long serialVersionUID = 5086048056432795799L;

	private Long id;
	private String nome;
	
	private Set<Permissao> permissoes;
}
