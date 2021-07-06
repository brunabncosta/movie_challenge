package com.challenge.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.movie.model.ImdbModel;
import com.challenge.movie.service.ImdbService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/imdb")
public class ImdbController {
	
	@Autowired
	private ImdbService imdbService;
	
	@ApiOperation(value = "Endpoint responsavel pela listagem de filmes")	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ImdbModel>> listarImdb(@RequestParam(required = false) String titulo){
		return imdbService.buscarImdb(titulo);
	}
	
}
