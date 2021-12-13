package com.polligonal.RedacaoEnem.dto;

import com.polligonal.RedacaoEnem.models.Usuario;

import lombok.Data;

@Data
public class CadastrarUsuarioDTO extends AbstractDTO<Usuario>{
	
	private static final long serialVersionUID = 5066961182067816135L;
	
	private String nome;
	private String email;
	private String senha;
	
	@Override
	public Usuario toModel() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		return usuario;
	}
}
