package com.lgleandrini.movie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meAjude")
public class MeAjudeEntity extends AbstractEntity<Long> {

	@OneToMany(mappedBy = "meAjudeEntity", cascade = { CascadeType.ALL })
	private List<IndicacaoEntity> indicacaoEntity;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuarioEntity;

	@Column(name = "titulo")
	private String titulo;

	public MeAjudeEntity() {
	}

	public MeAjudeEntity(UsuarioEntity usuarioEntity, String titulo) {
		super();
		this.usuarioEntity = usuarioEntity;
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public void addIndicacao(IndicacaoEntity indicacao) {
		if (indicacaoEntity == null) {
			indicacaoEntity = new ArrayList<IndicacaoEntity>();
		}
		indicacaoEntity.add(indicacao);
	}

}
