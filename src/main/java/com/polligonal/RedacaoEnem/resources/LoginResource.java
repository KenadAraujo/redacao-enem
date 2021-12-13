package com.polligonal.RedacaoEnem.resources;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polligonal.RedacaoEnem.dto.LoginDTO;
import com.polligonal.RedacaoEnem.dto.MensagemDTO;

@RestController("/login")
public class LoginResource {

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDTO login){
		return ResponseEntity.ok(new MensagemDTO(null));
	}
}
