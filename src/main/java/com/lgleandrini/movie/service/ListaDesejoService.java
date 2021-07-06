package com.lgleandrini.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lgleandrini.movie.entity.AvaliacaoEntity;
import com.lgleandrini.movie.entity.ListaDesejoEntity;
import com.lgleandrini.movie.entity.UsuarioEntity;
import com.lgleandrini.movie.model.AvaliacaoModel;
import com.lgleandrini.movie.model.FilmeIdModel;
import com.lgleandrini.movie.model.FilmeModel;
import com.lgleandrini.movie.model.ListaDesejoModel;
import com.lgleandrini.movie.repository.ListaDesejoRepository;
import com.lgleandrini.movie.repository.ListaDesejoRepositoryImpl;
import com.lgleandrini.movie.repository.UsuarioRepository;
import com.lgleandrini.movie.request.ImdbRequests;

@Service
public class ListaDesejoService {
	@Autowired
	private ListaDesejoRepository listaDesejoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ImdbRequests imdbRequests;
	
	@Autowired
	private ListaDesejoRepositoryImpl listaDesejoRepositoryImpl;

	public ResponseEntity<String> criaListaDesejos(FilmeIdModel filmeIdModel) {

		FilmeModel filme = imdbRequests.buscaFilmeId(filmeIdModel.getId());
		if (filme == null) {
			return new ResponseEntity<String>("Falha de comunicação com a api", HttpStatus.NOT_FOUND);
		}
		Optional<UsuarioEntity> usuario = usuarioRepository.findById(filmeIdModel.getUserId());
		ListaDesejoEntity desejo = new ListaDesejoEntity(usuario.get(), null, filme.getTitle(), filme.getGenre(),
				filme.getActors(), filme.getDirector(), true, filme.getImdbID());
		usuario.get().addListaDesejo(desejo);
		ListaDesejoEntity save = listaDesejoRepository.save(desejo);
		if (save == null) {
			return new ResponseEntity<String>("Falha ao inserir os dados no banco", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Sucesso", HttpStatus.ACCEPTED);

	}
	
	public List<ListaDesejoModel> filtra(String idUsuario, String genero, String autor, String diretor) {
		return listaDesejoRepositoryImpl.buscarFiltro(idUsuario, genero, autor, diretor);
	}

	public ResponseEntity<String> adicionaAvaliacao(String id, AvaliacaoModel avaliacao) {
		Optional<ListaDesejoEntity> optional = listaDesejoRepository.findById(Long.parseLong(id));
		if (optional.isPresent()) {
			ListaDesejoEntity listaDesejoEntity = optional.get();
			if (listaDesejoEntity.getAvaliacao() == null) {
				listaDesejoEntity.setAvaliacao(new AvaliacaoEntity(avaliacao.getNota(), avaliacao.getEstrela(),
						avaliacao.getComentario(), avaliacao.getPrivacidade(), listaDesejoEntity));
			} else {

				if (avaliacao.getNota() != null) {
					listaDesejoEntity.getAvaliacao().setNota(avaliacao.getNota());
				}
				if (avaliacao.getEstrela() != null) {
					listaDesejoEntity.getAvaliacao().setEstrela(avaliacao.getEstrela());
				}
				if (avaliacao.getNota() != null) {
					listaDesejoEntity.getAvaliacao().setComentario(avaliacao.getComentario());
				}
				if (avaliacao.getPrivacidade() != null) {
					listaDesejoEntity.getAvaliacao().setPrivacidade(avaliacao.getPrivacidade());
				}

			}

			ListaDesejoEntity desejo = listaDesejoRepository.save(listaDesejoEntity);
			if (desejo != null) {
				return new ResponseEntity<String>("Sucesso", HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<String>("Falha ao inserir os dados no banco", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Falha ao inserir os dados no banco", HttpStatus.NOT_FOUND);
	}
}
