package com.polligonal.RedacaoEnem.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polligonal.RedacaoEnem.dto.MensagemDTO;

@RestController
public class HelloResource {

	@GetMapping("/hello")
	public ResponseEntity<?> hello(){
		return ResponseEntity.ok(new MensagemDTO("Sistema funcionando!"));
	}
	
}
