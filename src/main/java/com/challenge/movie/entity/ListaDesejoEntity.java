package com.challenge.movie.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "listaDesejo")
public class ListaDesejoEntity extends AbstractEntity<Long> {

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuarioEntity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "avaliacao_id", referencedColumnName = "id")
	private AvaliacaoEntity avaliacao;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "genero")
	private String genero;

	@Column(name = "ator")
	private String ator;

	@Column(name = "diretor")
	private String diretor;

	@Column(name = "visibilidade")
	private boolean visibilidade;

	@Column(name = "imdbID")
	private String imdbID;

	public ListaDesejoEntity() {
	}

	public ListaDesejoEntity(UsuarioEntity usuarioEntity, AvaliacaoEntity avaliacao, String titulo, String genero,
			String ator, String diretor, boolean visibilidade, String imdbID) {
		super();
		this.usuarioEntity = usuarioEntity;
		this.avaliacao = avaliacao;
		this.titulo = titulo;
		this.genero = genero;
		this.ator = ator;
		this.diretor = diretor;
		this.visibilidade = visibilidade;
		this.imdbID = imdbID;
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

	public boolean isVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public AvaliacaoEntity getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoEntity avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

}
