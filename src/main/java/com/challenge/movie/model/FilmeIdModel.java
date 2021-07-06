package com.challenge.movie.model;

public class FilmeIdModel {

	private String id;
	private long userId;

	public FilmeIdModel() {
	}

	public FilmeIdModel(String id, long userId) {
		this.id = id;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
