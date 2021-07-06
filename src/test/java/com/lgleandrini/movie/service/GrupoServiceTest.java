package com.lgleandrini.movie.service;

import static org.junit.Assert.assertEquals;

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

import com.lgleandrini.movie.model.ComentarioModel;
import com.lgleandrini.movie.model.GrupoModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class GrupoServiceTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	@Test
	void criarGrupoTest() throws Exception {
		GrupoModel grupoModel = new GrupoModel("Luiz", true, 1);
		final String baseUrl = "http://localhost:" + randomServerPort + "/grupo";
		URI uri = new URI(baseUrl);

		HttpEntity<GrupoModel> request = new HttpEntity<GrupoModel>(grupoModel);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
		assertEquals(202, result.getStatusCodeValue());
	}
	
	@Test
	void adiconarComentarioTest() throws Exception {
		ComentarioModel comentarioModel = new ComentarioModel("Comentario", 1);
		final String baseUrl = "http://localhost:" + randomServerPort + "/grupo/comentario/1";
		URI uri = new URI(baseUrl);

		HttpEntity<ComentarioModel> request = new HttpEntity<ComentarioModel>(comentarioModel);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
		assertEquals(202, result.getStatusCodeValue());
	}

}
