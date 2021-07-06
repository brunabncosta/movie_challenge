package com.challenge.movie.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class IndicacaoEntity extends AbstractEntity<Long>{
	
	
	@Column(name = "nota")
	private int nota;
	
	@Column(name = "estrela")
	private int estrela;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuarioEntity;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "indicacao_id")
	private MeAjudeEntity meAjudeEntity;
	
	@Column(name = "imdbID")
	private String imdbID;
	
	public IndicacaoEntity() {
	}
	
	public IndicacaoEntity(int nota, int estrela, UsuarioEntity usuarioEntity, MeAjudeEntity meAjudeEntity, String imdbID) {
		this.nota = nota;
		this.estrela = estrela;
		this.usuarioEntity = usuarioEntity;
		this.meAjudeEntity = meAjudeEntity;
		this.imdbID = imdbID;
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


}
