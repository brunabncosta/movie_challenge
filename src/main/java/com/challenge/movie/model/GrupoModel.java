package com.challenge.movie.model;

public class GrupoModel {

	private String nome;
	private boolean visibilidade;
	private long userId;

	public GrupoModel() {
	}

	public GrupoModel(String nome, boolean visibilidade, long userId) {
		this.nome = nome;
		this.visibilidade = visibilidade;
		this.userId = userId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
