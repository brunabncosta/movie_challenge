package com.lgleandrini.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lgleandrini.movie.model.ImdbModel;
import com.lgleandrini.movie.request.ImdbRequests;

@Service
public class ImdbService {
	
	@Autowired
	private ImdbRequests imdbRequests;
	
	public ResponseEntity<List<ImdbModel>> buscarImdb(String titulo) {
		return new ResponseEntity<List<ImdbModel>>(imdbRequests.buscaImdb(titulo), HttpStatus.ACCEPTED);
	}

}
