package com.challenge.movie.model;

public class IndicacaoModel {

	private int nota;
	private int estrela;
	private String imdbID;
	private long userId;

	public IndicacaoModel() {
	}

	public IndicacaoModel(int nota, int estrela, String imdbID, long userId) {
		super();
		this.nota = nota;
		this.estrela = estrela;
		this.imdbID = imdbID;
		this.userId = userId;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getEstrela() {
		return estrela;
	}

	public void setEstrela(int estrela) {
		this.estrela = estrela;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
