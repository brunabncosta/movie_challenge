package com.lgleandrini.movie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class GrupoEntity extends AbstractEntity<Long>{

	@Column(name = "nome", unique = true)
	private String nome;
	@Column(name = "visibilidade")
	private boolean visibilidade;

	public GrupoEntity() {
	}

	public GrupoEntity(String nome, boolean visibilidade) {
		this.nome = nome;
		this.visibilidade = visibilidade;
	}

	@ManyToMany(fetch=FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name = "lista_usuario",
			joinColumns = @JoinColumn(name = "grupo_id"),
			inverseJoinColumns = @JoinColumn(name = "lista_id")
			)
	private List<UsuarioEntity> usuario;
	
	@OneToMany(mappedBy = "grupo", cascade = {CascadeType.ALL})
	private List<ComentarioEntity> comentarioEntity;


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

	public List<UsuarioEntity> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<UsuarioEntity> usuario) {
		this.usuario = usuario;
	}


	public List<ComentarioEntity> getComentario() {
		return comentarioEntity;
	}

	public void setComentario(List<ComentarioEntity> comentario) {
		this.comentarioEntity = comentario;
	}

	public void addUsuario(UsuarioEntity tempUsuario) {
		if (usuario == null) {
			usuario = new ArrayList<>();
		}
		usuario.add(tempUsuario);
		
	}
	
	public void addComentario(ComentarioEntity tempComentario) {
		if(comentarioEntity == null) {
			comentarioEntity = new ArrayList<>();
		}
		comentarioEntity.add(tempComentario);
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nome=" + nome + ", visibilidade=" + visibilidade + ", usuario=" + usuario + "]";
	}

}
