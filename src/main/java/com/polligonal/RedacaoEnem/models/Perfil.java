package com.polligonal.RedacaoEnem.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Perfil implements Serializable{

	private static final long serialVersionUID = 5086048056432795799L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@ManyToMany(mappedBy = "perfis")
	private Set<Permissao> permissoes;
	
	@ManyToMany(mappedBy = "perfis")
	private Set<Usuario> usuarios;
}
