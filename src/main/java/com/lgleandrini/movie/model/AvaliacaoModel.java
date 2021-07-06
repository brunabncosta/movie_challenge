package com.lgleandrini.movie.model;

public class AvaliacaoModel {

	private Double nota;
	private Integer estrela;
	private String comentario;
	private Boolean privacidade;
	private String userId;

	public AvaliacaoModel() {
	}

	public AvaliacaoModel(Double nota, Integer estrela, String comentario, Boolean privacidade, String userId) {
		this.nota = nota;
		this.estrela = estrela;
		this.comentario = comentario;
		this.privacidade = privacidade;
		this.userId = userId;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getEstrela() {
		return estrela;
	}

	public void setEstrela(Integer estrela) {
		this.estrela = estrela;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Boolean getPrivacidade() {
		return privacidade;
	}

	public void setPrivacidade(Boolean privacidade) {
		this.privacidade = privacidade;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
