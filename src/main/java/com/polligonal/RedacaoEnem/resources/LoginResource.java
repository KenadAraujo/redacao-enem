package com.polligonal.RedacaoEnem.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polligonal.RedacaoEnem.dto.MensagemDTO;

@RestController("/login")
public class LoginResource {

	@PostMapping
	public ResponseEntity<?> logar(){
		return ResponseEntity.ok(new MensagemDTO(null));
	}
}
