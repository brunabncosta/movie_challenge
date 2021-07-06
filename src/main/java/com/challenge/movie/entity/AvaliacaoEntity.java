package com.challenge.movie.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "avaliacao")
public class AvaliacaoEntity extends AbstractEntity<Long> {

	@Min(value = 5)
	@Max(value = 10)
	@Column(name = "nota")
	private double nota;
	
	@Min(value = 1)
	@Max(value = 5)
	@Column(name = "estrela")
	private int estrela;
	

	@Column(name = "comentario", unique = true)
	private String comentario;
	
	@Column(name = "privacidade")
	private boolean privacidade;
	
	@OneToOne(mappedBy = "avaliacao", cascade = CascadeType.ALL)
	private ListaDesejoEntity listaDesejo;

	public AvaliacaoEntity() {
	}

	public AvaliacaoEntity(double nota, int estrela, String comentario, boolean privacidade,
			ListaDesejoEntity listaDesejo) {
		this.nota = nota;
		this.estrela = estrela;
		this.comentario = comentario;
		this.privacidade = privacidade;
		this.listaDesejo = listaDesejo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getEstrela() {
		return estrela;
	}

	public void setEstrela(int estrela) {
		this.estrela = estrela;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public ListaDesejoEntity getListaDesejo() {
		return listaDesejo;
	}

	public void setListaDesejo(ListaDesejoEntity listaDesejo) {
		this.listaDesejo = listaDesejo;
	}

	public boolean isPrivacidade() {
		return privacidade;
	}

	public void setPrivacidade(boolean privacidade) {
		this.privacidade = privacidade;
	}

}
