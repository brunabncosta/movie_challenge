package com.lgleandrini.movie.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmeModel {

	@JsonProperty("Title")
	private String title;

	@JsonProperty("Genre")
	private String genre;

	@JsonProperty("Director")
	private String director;

	@JsonProperty("Actors")
	private String actors;

	@JsonProperty("imdbID")
	private String imdbID;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	@JsonProperty("Title")
	public String getTitle() {
		return title;
	}
	@JsonProperty("Title")
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonProperty("Genre")
	public String getGenre() {
		return genre;
	}
	@JsonProperty("Genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@JsonProperty("Director")
	public String getDirector() {
		return director;
	}
	@JsonProperty("Director")
	public void setDirector(String director) {
		this.director = director;
	}
	@JsonProperty("Actors")
	public String getActors() {
		return actors;
	}
	@JsonProperty("Actors")
	public void setActors(String actors) {
		this.actors = actors;
	}
	@JsonProperty("imdbID")
	public String getImdbID() {
		return imdbID;
	}
	@JsonProperty("imdbID")
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
