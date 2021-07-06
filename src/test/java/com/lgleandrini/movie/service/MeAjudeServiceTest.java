package com.challenge.movie.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.movie.model.IndicacaoModel;
import com.challenge.movie.model.MeAjudeModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MeAjudeServiceTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	int randomServerPort;
	
	
	@Test
	void criarMeAjudeTest() throws Exception {
		MeAjudeModel meAjudeModel = new MeAjudeModel(1, "Me ajude achar um filme");
		final String baseUrl = "http://localhost:" + randomServerPort + "/meajude";
		URI uri = new URI(baseUrl);

		HttpEntity<MeAjudeModel> request = new HttpEntity<MeAjudeModel>(meAjudeModel);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
		assertEquals(202, result.getStatusCodeValue());
	}
	
	@Test
	void criarSugestaoTest() throws Exception {
		IndicacaoModel indicacaoModel = new IndicacaoModel(7, 3, "tt0145487", 1);
		final String baseUrl = "http://localhost:" + randomServerPort + "/desejo";
		URI uri = new URI(baseUrl);

		HttpEntity<IndicacaoModel> request = new HttpEntity<IndicacaoModel>(indicacaoModel);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
		assertEquals(202, result.getStatusCodeValue());
	}
	
	
//	@Test
//	void criarGrupoTest() {
//		MeAjudeModel meAjudeModel = new MeAjudeModel(1, "Este filme é bom?");
//		ResponseEntity<String> criarGrupo = meAjudeService.criarGrupo(meAjudeModel);
//		assertEquals("Indicação pedida", criarGrupo.getBody());			
//	}
//	
//	@Test
//	void adicionaIndicacaoTest() {		
//		IndicacaoModel indicacaoModel = new IndicacaoModel(7, 4, "tt0372784", 1);
//		ResponseEntity<String> adicionaIndicacao = meAjudeService.adicionaIndicacao("1", indicacaoModel);
//		assertEquals("Indicação feita", adicionaIndicacao.getBody());			
//	}
	
}
