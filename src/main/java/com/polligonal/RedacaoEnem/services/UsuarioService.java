package com.polligonal.RedacaoEnem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polligonal.RedacaoEnem.dto.CadastrarUsuarioDTO;
import com.polligonal.RedacaoEnem.models.Usuario;
import com.polligonal.RedacaoEnem.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void cadastrar(CadastrarUsuarioDTO novoUsuario) {
		Usuario usuario = novoUsuario.toModel();
		usuarioRepository.save(usuario);
	}
}
