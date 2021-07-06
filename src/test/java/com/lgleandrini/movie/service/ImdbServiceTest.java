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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ImdbServiceTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	int randomServerPort;
	
	@Test
	void listarImdbTest() throws Exception {

		final String baseUrl = "http://localhost:" + randomServerPort + "/imdb";
		URI uri = new URI(baseUrl);

		ResponseEntity<List> responseEntity = this.restTemplate.getForEntity(uri, List.class);

		assertEquals(202, responseEntity.getStatusCodeValue());
	}
	
	
	
//	@Autowired
//	private ImdbService imdbService;
//	
//	@Test
//	void buscarImdbTest() {
//		ResponseEntity<List<ImdbModel>> buscarImdb = imdbService.buscarImdb("batman");
//		assertEquals(1, buscarImdb.getBody().size());			
//	}
	
}
