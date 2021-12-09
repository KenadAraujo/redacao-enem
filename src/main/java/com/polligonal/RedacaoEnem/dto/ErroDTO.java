package com.polligonal.RedacaoEnem.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ErroDTO {
	
	private String mensagem;
	private Date dataErro;
	
	public ErroDTO(String mensagem) {
		this.mensagem = mensagem;
		this.dataErro = new Date();
	}
}
