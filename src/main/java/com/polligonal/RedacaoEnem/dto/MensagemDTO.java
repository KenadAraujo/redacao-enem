package com.polligonal.RedacaoEnem.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MensagemDTO implements Serializable {
	
	private static final long serialVersionUID = -5334971984083097796L;
	
	private String mensagem;
	private Date dataErro;
	
	public MensagemDTO(String mensagem) {
		this.mensagem = mensagem;
		this.dataErro = new Date();
	}
}
