package com.challenge.movie.model;

public class MeAjudeModel {

	private long userId;
	private String titulo;

	public MeAjudeModel() {
	}

	public MeAjudeModel(long userId, String titulo) {
		this.userId = userId;
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
