package com.polligonal.RedacaoEnem.dto;

import java.io.Serializable;

public abstract class AbstractDTO<T> implements Serializable{

	private static final long serialVersionUID = 3899840801094008882L;

	public abstract T toModel();
}
