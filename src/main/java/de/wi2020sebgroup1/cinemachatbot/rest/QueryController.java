package de.wi2020sebgroup1.cinemachatbot.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import de.wi2020sebgroup1.cinemachatbot.entity.Movie;
import de.wi2020sebgroup1.cinemachatbot.entity.Response;
import de.wi2020sebgroup1.cinemachatbot.enumeration.ResponseType;

@Controller
@RestController
@RequestMapping("/query")
public class QueryController {

//	String baseURL = "https://wi2020seb-cinema-api.azurewebsites.net/";
	String baseURL = "https://wi2020seb-cinema-api-dev.azurewebsites.net/";
	
	@GetMapping("/{query}")
	public ResponseEntity<Object> getQueryResponse(@PathVariable String query){
		
		List<Movie> movies = getMoviesForQuery(query);
		if(movies.size() == 1)
			return new ResponseEntity<Object>(new Response(ResponseType.MOVIE, movies.get(0)), HttpStatus.OK);
	    else {
			
			if(QueryValidator.isDate(query)) {
				
				//To Do: change to show/{date}
				String uri = baseURL+"show/getAll";
				RestTemplate t = new RestTemplate();
			    Object result = t.getForObject(uri, Object.class);
				return new ResponseEntity<Object>(new Response(ResponseType.SHOWLIST, result), HttpStatus.OK);
				
			} else if(QueryValidator.isEmail(query)) {
				return new ResponseEntity<>(new Response(ResponseType.LINK, "localhost:8080"), HttpStatus.OK);
			} else if(QueryValidator.contains(query, "show", "shows", "vorstellung", "vorstellungen")) {

				String uri = baseURL+"show/getAll";
				RestTemplate t = new RestTemplate();
			    Object result = t.getForObject(uri, Object.class);
				return new ResponseEntity<Object>(new Response(ResponseType.SHOWLIST, result), HttpStatus.OK);
				
			} else if(QueryValidator.contains(query, "profil", "profile")) {

				return new ResponseEntity<Object>(new Response(ResponseType.LINK, "localhost:8080"), HttpStatus.OK);
				
			} else if(QueryValidator.contains(query, "movie", "movies", "film", "filme")) {

				String uri = baseURL+"movie/getAll";
				RestTemplate t = new RestTemplate();
			    Object result = t.getForObject(uri, Object.class);
				return new ResponseEntity<Object>(new Response(ResponseType.MOVIELIST, result), HttpStatus.OK);
				
			} else if(query == "187") {
				return new ResponseEntity<Object>(new Response(ResponseType.STRING, "187! ~ Zitat Jan C. Stengert, 29.12.2021, Bad Zwischenahn"), HttpStatus.OK);
			} else {
				
				String uri = baseURL+"movie/getAll";
				RestTemplate t = new RestTemplate();
			    ResponseEntity<Movie[]> responseEntity = t.getForEntity(uri, Movie[].class);
			    Movie[] response = responseEntity.getBody();
			    List<Movie> result = new ArrayList<>();
			    for(Movie m : response) {
			    	if(QueryValidator.similarity(m.getTitle(), query) > 0.7 && !result.contains(m)) {
			    		result.add(m);
			    		continue;
			    	} else if(QueryValidator.similarity(m.getOriginalTitle(), query) > 0.7 && !result.contains(m)) {
			    		result.add(m);
			    		continue;
			    	} else if(QueryValidator.similarity(m.getDirector(), query) > 0.7 && !result.contains(m)) {
			    		result.add(m);
			    		continue;
			    	} else if(QueryValidator.somewhereRoughlyContains(query, m.getTitle()) && !result.contains(m)) {
			    		result.add(m);
			    		continue;
			    	} else if(QueryValidator.somewhereRoughlyContains(query, m.getOriginalTitle()) && !result.contains(m)) {
			    		result.add(m);
			    		continue;
			    	} else if(QueryValidator.somewhereRoughlyContains(query, m.getDirector()) && !result.contains(m)) {
			    		result.add(m);
			    		continue;
			    	}
			    }
				if(result.size() == 1)
					return new ResponseEntity<Object>(new Response(ResponseType.MOVIE, result.get(0)), HttpStatus.OK);
				else if(result.size() > 0)
					return new ResponseEntity<Object>(new Response(ResponseType.MOVIELIST, result), HttpStatus.OK);
				return new ResponseEntity<>(new Response(ResponseType.STRING, "Ich konnte deine Anfrage leider nicht verstehen :("), HttpStatus.OK);
				
			}
	    }
		
	}
	
	private List<Movie> getMoviesForQuery(String query) {
		
		query = query.replace("_", " ");
		
		String uri = baseURL+"movie/getAll";
		RestTemplate t = new RestTemplate();
	    ResponseEntity<Movie[]> responseEntity =
	    		  t.getForEntity(
	    		  uri,
	    		  Movie[].class);
	    Movie[] response = responseEntity.getBody();
	    List<Movie> result = new ArrayList<>();
	    for(Movie m : response) {
	    	if(m.getTitle().equalsIgnoreCase(query) && !result.contains(m))
	    		result.add(m);
	    	if(m.getOriginalTitle().equalsIgnoreCase(query) && !result.contains(m))
	    		result.add(m);
	    	if(m.getDirector().equalsIgnoreCase(query) && !result.contains(m))
	    		result.add(m);
	    }
	    
	    return result;
		
	}
	
}
