package com.lgleandrini.movie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lgleandrini.movie.entity.ComentarioEntity;
import com.lgleandrini.movie.entity.GrupoEntity;
import com.lgleandrini.movie.entity.UsuarioEntity;
import com.lgleandrini.movie.model.ComentarioModel;
import com.lgleandrini.movie.model.GrupoModel;
import com.lgleandrini.movie.repository.GrupoRepository;
import com.lgleandrini.movie.repository.UsuarioRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	public ResponseEntity<String> criaGrupo(GrupoModel grupoModel) {
		GrupoEntity grupo = new GrupoEntity(grupoModel.getNome(), grupoModel.isVisibilidade());
		Optional<UsuarioEntity> optionalUser = usuarioRepository.findById(grupoModel.getUserId());
		UsuarioEntity usuario = optionalUser.get();
		usuario.addGrupos(grupo);
		GrupoEntity entity = grupoRepository.save(grupo);
		if(entity != null) {
			return new ResponseEntity<String>("Grupo criado com sucesso", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Erro ao criar grupo", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<String> adicionaComentario(String id, ComentarioModel comentarioModel) {
		 Optional<GrupoEntity> optional = grupoRepository.findById(Long.parseLong(id));
		 Optional<UsuarioEntity> optionalUser = usuarioRepository.findById(comentarioModel.getUserId());
		 UsuarioEntity usuario = optionalUser.get();
		 GrupoEntity entity = optional.get();
		 ComentarioEntity comentario = new ComentarioEntity(comentarioModel.getComentario(), usuario, entity);
		 entity.getComentario().add(comentario);
		 usuario.addComentario(comentario);
		 entity = grupoRepository.save(entity);
			if(entity != null) {
				return new ResponseEntity<String>("Comentario criado com sucesso", HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<String>("Erro ao criar comentario", HttpStatus.NOT_FOUND);
	}
}
