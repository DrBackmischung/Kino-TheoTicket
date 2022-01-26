package de.wi2020sebgroup1.cinemachatbot.enumeration;

public enum ResponseType {
	
	STRING("String"),
	LINK("Link"),
	MOVIE("Movie"),
	MOVIELIST("MovieList"),
	SHOWLIST("ShowList");
	
	private String value;

	ResponseType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
