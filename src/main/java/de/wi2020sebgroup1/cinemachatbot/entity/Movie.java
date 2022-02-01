package de.wi2020sebgroup1.cinemachatbot.entity;

import java.util.UUID;

import org.jetbrains.annotations.NotNull;

public class Movie {
	
	private UUID id;
	private String title;
	private String originalTitle;
	private String language;
	private double duration;
	private String genre;
	private String director;
	private String actors;
	private String description;
	private String originalDescription;
	private String pictureLink;
	private String trailerLink;
	private int FSK;
	
	public Movie() {}
	
	public Movie(@NotNull String titel, @NotNull String originalTitle , @NotNull String language, @NotNull double duration, @NotNull String director,
			@NotNull String actors,@NotNull String description, @NotNull String originalDescription, @NotNull String pictureLink, 
			@NotNull String trailerLink, @NotNull String genre, @NotNull int FSK) {
		super();
		this.title = titel;
		this.originalTitle = originalTitle;
		this.genre = genre;
		this.language = language;
		this.duration = duration;
		this.director = director;
		this.actors = actors;
		this.description = description;
		this.originalDescription = originalDescription;
		this.pictureLink = pictureLink;
		this.trailerLink = trailerLink;
		this.FSK = FSK;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getOriginalDescription() {
		return originalDescription;
	}

	public void setOriginalDescription(String originalDescription) {
		this.originalDescription = originalDescription;
	}

	public String getTrailerLink() {
		return trailerLink;
	}

	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", originalTitle=" + originalTitle + ", language=" + language
				+ ", duration=" + duration + ", genre=" + genre + ", director=" + director + ", actors=" + actors
				+ ", description=" + description + ", originalDescription=" + originalDescription + ", pictureLink="
				+ pictureLink + ", trailerLink=" + trailerLink + ", FSK=" + FSK + "]";
	}
	
}
