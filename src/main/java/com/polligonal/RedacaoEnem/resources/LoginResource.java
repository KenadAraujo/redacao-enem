package com.polligonal.RedacaoEnem.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polligonal.RedacaoEnem.config.security.TokenService;
import com.polligonal.RedacaoEnem.dto.LoginDTO;
import com.polligonal.RedacaoEnem.dto.MensagemDTO;
import com.polligonal.RedacaoEnem.dto.TokenDTO;

@RestController
@RequestMapping("/login")
public class LoginResource {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDTO login){
		UsernamePasswordAuthenticationToken dadosLogin = login.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().body(new MensagemDTO(e.getMessage()));
		}

	}
}
