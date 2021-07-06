package com.lgleandrini.movie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lgleandrini.movie.entity.IndicacaoEntity;
import com.lgleandrini.movie.entity.MeAjudeEntity;
import com.lgleandrini.movie.entity.UsuarioEntity;
import com.lgleandrini.movie.model.IndicacaoModel;
import com.lgleandrini.movie.model.MeAjudeModel;
import com.lgleandrini.movie.repository.MeAjudeRepository;
import com.lgleandrini.movie.repository.UsuarioRepository;

@Service
public class MeAjudeService {
	
	@Autowired
	private MeAjudeRepository meAjudeRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public ResponseEntity<String> criarGrupo(MeAjudeModel meAjudeModel) {
		Optional<UsuarioEntity> optional = usuarioRepository.findById(meAjudeModel.getUserId());
		UsuarioEntity usuario = optional.get();
		
		MeAjudeEntity ajuda = new MeAjudeEntity(usuario, meAjudeModel.getTitulo());
		usuario.addMeAjude(ajuda);
		
		MeAjudeEntity entity = meAjudeRepository.save(ajuda);
		if(entity != null) {
			return new ResponseEntity<String>("Indicação pedida", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Nao foi possivel pedir indicacoes", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<String> adicionaIndicacao(String id, IndicacaoModel indicacao) {
		Optional<MeAjudeEntity> optional = meAjudeRepository.findById(Long.parseLong(id));
		Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findById(indicacao.getUserId());
		UsuarioEntity usuarioEntity = optionalUsuario.get();
		MeAjudeEntity entity = optional.get();
		entity.addIndicacao(new IndicacaoEntity(indicacao.getNota(), indicacao.getEstrela(), usuarioEntity, entity, indicacao.getImdbID()));
//		entity = meAjudeRepository.save(entity);
		usuarioEntity.addMeAjude(entity);
		UsuarioEntity save = usuarioRepository.save(usuarioEntity);
		if(save != null) {
			return new ResponseEntity<String>("Indicação feita", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Nao foi possivel fazer indicacoes", HttpStatus.NOT_FOUND);
	}
}
