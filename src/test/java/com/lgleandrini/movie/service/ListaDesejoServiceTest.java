package com.lgleandrini.movie.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.lgleandrini.movie.model.AvaliacaoModel;
import com.lgleandrini.movie.model.FilmeIdModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ListaDesejoServiceTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	@Test
	void adicionarTest() throws Exception {
		FilmeIdModel filmeIdModel = new FilmeIdModel("tt0372784", 1);
		final String baseUrl = "http://localhost:" + randomServerPort + "/desejo";
		URI uri = new URI(baseUrl);

		HttpEntity<FilmeIdModel> request = new HttpEntity<FilmeIdModel>(filmeIdModel);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
		assertEquals(202, result.getStatusCodeValue());
	}

	@Test
	void filtroTeste() throws Exception {

		final String baseUrl = "http://localhost:" + randomServerPort + "/desejo?idUsuario=1&diretor=Nolan";
		URI uri = new URI(baseUrl);

		ResponseEntity<List> responseEntity = this.restTemplate.getForEntity(uri, List.class);

		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	void avaliarTest() throws Exception {
		AvaliacaoModel avaliacaoModel = new AvaliacaoModel(7.0, 3, "comentario", false, "1");
		final String baseUrl = "http://localhost:" + randomServerPort + "/desejo/avaliar/1";
		URI uri = new URI(baseUrl);

		HttpEntity<AvaliacaoModel> request = new HttpEntity<AvaliacaoModel>(avaliacaoModel);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
		assertEquals(202, result.getStatusCodeValue());
	}

	@Test
	void avaliarUpdateTest() throws Exception {
		AvaliacaoModel avaliacaoModel = new AvaliacaoModel(6.0, 2, "comentario 2", false, "1");
		final String baseUrl = "http://localhost:" + randomServerPort + "/desejo/avaliar/1";
		URI uri = new URI(baseUrl);

		HttpEntity<AvaliacaoModel> request = new HttpEntity<AvaliacaoModel>(avaliacaoModel);

		ResponseEntity<String> result = this.restTemplate.exchange(uri, HttpMethod.PUT, request, String.class);

		assertEquals(202, result.getStatusCodeValue());
	}
}
