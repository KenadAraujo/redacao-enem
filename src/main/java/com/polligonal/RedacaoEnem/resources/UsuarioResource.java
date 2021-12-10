package com.polligonal.RedacaoEnem.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polligonal.RedacaoEnem.dto.CadastrarUsuarioDTO;
import com.polligonal.RedacaoEnem.dto.MensagemDTO;
import com.polligonal.RedacaoEnem.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(CadastrarUsuarioDTO cadastrar){
		usuarioService.cadastrar(cadastrar);
		return ResponseEntity.ok().body(new MensagemDTO("Cadastrado com sucesso!"));
	}
	
	@PostMapping("/{id}/recuperar-senha")
	public ResponseEntity<?> recuperarSenha(@PathVariable("id")Long id){
		return ResponseEntity.ok().body(new MensagemDTO("Senha Recuperada com sucesso!Usuario:"+id));
	}
}
