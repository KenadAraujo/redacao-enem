package com.polligonal.RedacaoEnem.config.security.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.polligonal.RedacaoEnem.config.security.TokenService;
import com.polligonal.RedacaoEnem.models.Perfil;
import com.polligonal.RedacaoEnem.models.Usuario;
import com.polligonal.RedacaoEnem.repository.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperaToken(request);
		
		boolean valido = tokenService.isTokenValido(token);
		if(valido) {
			autenticarUsuario(token);
		}
		filterChain.doFilter(request, response);
	}

	private void autenticarUsuario(String token) {
		Long  idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario = usuarioRepository.getOne(idUsuario);
		UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(usuario, null,null);
		SecurityContextHolder.getContext().setAuthentication(null);
	}

	private String recuperaToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}

}
