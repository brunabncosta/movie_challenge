package com.challenge.movie.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbModel {
	
	public ImdbModel() {
	}

	public ImdbModel(List<ImdbInnerModel> search) {
		this.search = search;
		
	}

	@JsonProperty("Search")
	private List<ImdbInnerModel> search = null;
	
	@JsonProperty("Search")
	public List<ImdbInnerModel> getSearch() {
		return search;
	}

	@JsonProperty("Search")
	public void setSearch(List<ImdbInnerModel> search) {
		this.search = search;
	}

	
}
