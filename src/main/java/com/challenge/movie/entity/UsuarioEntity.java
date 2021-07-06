package com.challenge.movie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioEntity extends AbstractEntity<Long>{

	
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "senha")
	private String senha;

	@OneToMany(mappedBy = "usuarioEntity", cascade = { CascadeType.ALL})
	private List<ListaDesejoEntity> listaDesejo;
	
	@OneToMany(mappedBy = "usuarioEntity", cascade = {CascadeType.ALL})
	private List<ComentarioEntity> comentarioEntity;

	@OneToMany(mappedBy = "usuarioEntity", cascade = { CascadeType.ALL })
	private List<MeAjudeEntity> meAjudeEntity;
	
	@OneToMany(mappedBy = "usuario", cascade = { CascadeType.ALL})
	private List<GrupoEntity> grupos;
	
	public UsuarioEntity() {
	}

	public UsuarioEntity(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + "]";
	}

	public List<ListaDesejoEntity> getListaDesejo() {
		return listaDesejo;
	}

	public void setListaDesejo(List<ListaDesejoEntity> listaDesejo) {
		this.listaDesejo = listaDesejo;
	}
	

	public List<ComentarioEntity> getComentario() {
		return comentarioEntity;
	}

	public void setComentario(List<ComentarioEntity> comentarioEntity) {
		this.comentarioEntity = comentarioEntity;
	}
	
	public void addComentario(ComentarioEntity tempComentario) {
		if(comentarioEntity == null) {
			comentarioEntity = new ArrayList<>();
		}
		comentarioEntity.add(tempComentario);
		tempComentario.setUsuarioEntity(this);
	}

	public void addListaDesejo(ListaDesejoEntity tempDesejo) {
		if(listaDesejo == null) {
			listaDesejo = new ArrayList<>();
		}
		listaDesejo.add(tempDesejo);
		tempDesejo.setUsuarioEntity(this);
	}
	
	public void addMeAjude(MeAjudeEntity tempAjuda) {
		if(meAjudeEntity == null) {
			meAjudeEntity = new ArrayList<>();
		}
		meAjudeEntity.add(tempAjuda);
		tempAjuda.setUsuarioEntity(this);
	}
	
	
	public void addGrupos(GrupoEntity tempGrupo) {
		if(grupos == null) {
			grupos = new ArrayList<>();
		}
		grupos.add(tempGrupo);
		tempGrupo.addUsuario(this);
	}
	
	
}
