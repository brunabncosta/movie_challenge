package com.lgleandrini.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lgleandrini.movie.model.IndicacaoModel;
import com.lgleandrini.movie.model.MeAjudeModel;
import com.lgleandrini.movie.service.MeAjudeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/meajude")
public class MeAjudeController {

	@Autowired
	private MeAjudeService meAjudeService;
	
	@ApiOperation(value = "Endpoint responsavel pela criação do pedido de sugestao")	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> criarMeAjude(@RequestBody MeAjudeModel ajuda){
		return meAjudeService.criarGrupo(ajuda);
	}
	
	@ApiOperation(value = "Endpoint responsavel pela criação da sugestao")	
	@RequestMapping(method = RequestMethod.POST, value = "/sugestao/{idMeAjude}")
	public ResponseEntity<String> criarSugestao(@PathVariable("idMeAjude") String id, @RequestBody(required = true) IndicacaoModel indicacao) {
		ResponseEntity<String> resposta = meAjudeService.adicionaIndicacao(id, indicacao);
		return resposta;
	}
}
