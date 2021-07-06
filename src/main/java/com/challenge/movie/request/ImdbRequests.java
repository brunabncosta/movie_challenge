package com.challenge.movie.request;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.challenge.movie.model.FilmeModel;
import com.challenge.movie.model.ImdbModel;

@Component
public class ImdbRequests {
	
	public List<ImdbModel> buscaImdb(String titulo){
		String url = "http://www.omdbapi.com/?s="+ titulo +"&apikey=f58196f1";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ImdbModel> response = restTemplate.getForEntity(url, ImdbModel.class);
		ImdbModel imdbArr = response.getBody();
		return Arrays.asList(imdbArr);
	}

	public FilmeModel buscaFilmeId(String idFilme) {
		String url = "http://www.omdbapi.com/?i="+ idFilme +"&apikey=f58196f1";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<FilmeModel> response = restTemplate.getForEntity(url, FilmeModel.class);
		FilmeModel filme = response.getBody();
		return filme;
	}
	
}
