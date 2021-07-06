package com.lgleandrini.movie.model;

public class ListaDesejoModel {

	private String titulo;
	private String genero;
	private String ator;
	private String diretor;
	private String imdb;

	public ListaDesejoModel() {
	}

	public ListaDesejoModel(String titulo, String genero, String ator, String diretor, String imdb) {
		this.titulo = titulo;
		this.genero = genero;
		this.ator = ator;
		this.diretor = diretor;
		this.imdb = imdb;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAtor() {
		return ator;
	}

	public void setAtor(String ator) {
		this.ator = ator;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

}
