package com.polligonal.RedacaoEnem.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ManyToMany;

import lombok.Data;

@Data
public class Permissao implements Serializable {

	private static final long serialVersionUID = -2903556409295902899L;
	private Long id;
	private String url;
	
	@ManyToMany(mappedBy = "permissoes")
	private Set<Perfil> perfis;
}
