package com.polligonal.RedacaoEnem.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.polligonal.RedacaoEnem.models.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${redacao.enem.tempo-expiracao-token}")
	private String tempoExpiracao;
	
	@Value("${redacao.enem.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime()+Long.parseLong(tempoExpiracao));
		return Jwts.builder()
				.setIssuer("Redação Enem")//Quem gerou o token
				.setSubject(usuario.getId().toString())//Usuario logado
				.setIssuedAt(hoje)//Data de geração do token
				.setExpiration(dataExpiracao)//Data da expiracao do token;
				.signWith(SignatureAlgorithm.HS256, secret)//Algoritmo de criptografia;
				.compact();
	}

}
