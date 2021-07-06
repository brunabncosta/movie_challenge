package com.lgleandrini.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lgleandrini.movie.model.ComentarioModel;
import com.lgleandrini.movie.model.GrupoModel;
import com.lgleandrini.movie.service.GrupoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@ApiOperation(value = "Endpoint responsavel pela criação de grupo")	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> criarGrupo(@RequestBody GrupoModel grupo){
		return grupoService.criaGrupo(grupo);
	}
	
	@ApiOperation(value = "Endpoint responsavel pela adição de comentarios no grupo")
	@RequestMapping(method = RequestMethod.POST, value = "/comentario/{idGrupo}")
	public ResponseEntity<String> adiconarComentario(@PathVariable("idGrupo") String id, @RequestBody(required = true) ComentarioModel comentario) {
		ResponseEntity<String> resposta = grupoService.adicionaComentario(id, comentario);
		return resposta;
	}


}
