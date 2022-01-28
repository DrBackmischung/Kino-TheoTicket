package de.wi2020sebgroup1.cinemachatbot.entity;

import java.util.UUID;

public class Movie {
	
	private UUID id;
	private String title;
	private String language;
	private double duration;
	private String director;
	private String description;
	private String pictureLink;
	private int FSK;
	
	public Movie() {}
	
	public Movie(UUID id, String title, String language, double duration, String director, String description,
			String pictureLink, int fSK) {
		super();
		this.id = id;
		this.title = title;
		this.language = language;
		this.duration = duration;
		this.director = director;
		this.description = description;
		this.pictureLink = pictureLink;
		FSK = fSK;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	public int getFSK() {
		return FSK;
	}

	public void setFSK(int fSK) {
		FSK = fSK;
	}
	
}
