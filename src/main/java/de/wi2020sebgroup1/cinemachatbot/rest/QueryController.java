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

@Controller
@RestController
@RequestMapping("/query")
public class QueryController {
	
	String baseURL = "https://wi2020seb-cinema-api.azurewebsites.net/";
	
	@GetMapping("/{query}")
	public ResponseEntity<Object> getQueryResponse(@PathVariable String query){
		
		query = query.replace("_", " ");
		
		if(QueryValidator.isNumeric(query)) {
			return new ResponseEntity<>("Es tut mir leid, aber ich kann dein Anliegen nicht verstehen :(", HttpStatus.OK);
		} else if(QueryValidator.isDate(query)) {
			
			//To Do: change to show/{date}
			String uri = baseURL+"show/getAll";
			RestTemplate t = new RestTemplate();
		    Object result = t.getForObject(uri, Object.class);
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		} else if(QueryValidator.isEmail(query)) {
			return new ResponseEntity<>("Um deine Email zu ändern, bearbeite deine Profildaten in den Einstellungen!", HttpStatus.OK);
		} else if(query.equalsIgnoreCase("show") || query.equalsIgnoreCase("shows") || query.equalsIgnoreCase("vorstellung") || query.equalsIgnoreCase("vorstellungen")) {

			String uri = baseURL+"show/getAll";
			RestTemplate t = new RestTemplate();
		    Object result = t.getForObject(uri, Object.class);
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		} else if(query.equalsIgnoreCase("movie") || query.equalsIgnoreCase("movies") || query.equalsIgnoreCase("filme") || query.equalsIgnoreCase("film")) {

			String uri = baseURL+"movie/getAll";
			RestTemplate t = new RestTemplate();
		    Object result = t.getForObject(uri, Object.class);
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		} else if(query.equalsIgnoreCase("room") || query.equalsIgnoreCase("rooms") || query.equalsIgnoreCase("saal") || query.equalsIgnoreCase("säle")) {

			String uri = baseURL+"cinemaRoom/getAll";
			RestTemplate t = new RestTemplate();
		    Object result = t.getForObject(uri, Object.class);
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		} else {
			
			String uri = baseURL+"movie/getAll";
			RestTemplate t = new RestTemplate();
		    @SuppressWarnings("unchecked")
//			Movie[] response = t.getForObject(uri, Movie[].class);
		    ResponseEntity<Movie[]> responseEntity =
		    		  t.getForEntity(
		    		  uri,
		    		  Movie[].class);
		    Movie[] response = responseEntity.getBody();
		    List<Movie> result = new ArrayList<>();
		    for(Movie m : response) {
		    	if(m.getTitel().equalsIgnoreCase(query) && !result.contains(m))
		    		result.add(m);
		    	if(m.getDirector().equalsIgnoreCase(query) && !result.contains(m))
		    		result.add(m);
		    }
		    if(result.size() > 0)
		    	return new ResponseEntity<>(result, HttpStatus.OK);
			return new ResponseEntity<>("Ich konnte deine Anfrage leider nicht verstehen :(", HttpStatus.OK);
			
		}
		
	}
	
}