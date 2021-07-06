package com.lgleandrini.movie.model;

public class ComentarioModel {

	private String comentario;
	private long userId;

	public ComentarioModel() {
	}

	public ComentarioModel(String comentario, long userId) {
		this.comentario = comentario;
		this.userId = userId;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
}
