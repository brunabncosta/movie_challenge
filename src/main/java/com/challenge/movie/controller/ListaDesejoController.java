package com.challenge.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.movie.model.AvaliacaoModel;
import com.challenge.movie.model.FilmeIdModel;
import com.challenge.movie.model.ListaDesejoModel;
import com.challenge.movie.service.ListaDesejoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/desejo")
public class ListaDesejoController {
	
	@Autowired
	private ListaDesejoService listaDesejoService;
	
	@ApiOperation(value = "Endpoint responsavel pela adição de um novo filme a lista de desejos")	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> adicionar(@RequestBody(required = true) FilmeIdModel filmeIdModel){
		return listaDesejoService.criaListaDesejos(filmeIdModel);
	}
	
	@ApiOperation(value = "Endpoint responsavel pela busca de filmes na lista de desejos")	
	@RequestMapping(method = RequestMethod.GET)
	public List<ListaDesejoModel> filtro(@RequestParam(required = true) String idUsuario, @RequestParam(required = false) String genero, @RequestParam(required = false) String autor, @RequestParam(required = false) String diretor){
		List<ListaDesejoModel> lista = listaDesejoService.filtra(idUsuario ,genero, autor, diretor);
		return lista;
	}
	
	@ApiOperation(value = "Endpoint responsavel pela avaliação do filme na lista de desejo")	
	@RequestMapping(method = RequestMethod.POST, value = "/avaliar/{idListaDesejo}")
	public ResponseEntity<String> avaliar(@PathVariable("idListaDesejo") String id, @RequestBody(required = true) AvaliacaoModel avaliacao) {
		ResponseEntity<String> resposta = listaDesejoService.adicionaAvaliacao(id, avaliacao);
		return resposta;
	}
	
	@ApiOperation(value = "Endpoint responsavel pela alteração da avaliação de um filme")	
	@RequestMapping(method = RequestMethod.PUT, value = "/avaliar/{idListaDesejo}")
	public ResponseEntity<String> avaliarUpdate(@PathVariable("idListaDesejo") String id, @RequestBody(required = true) AvaliacaoModel avaliacao) {
		ResponseEntity<String> resposta = listaDesejoService.adicionaAvaliacao(id, avaliacao);
		return resposta;
	}
	
}
