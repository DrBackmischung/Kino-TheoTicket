package de.wi2020sebgroup1.cinemachatbot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
@RestController
@RequestMapping("/select")
public class SelectedCallController {
	
	String baseURL = "https://wi2020seb-cinema-api.azurewebsites.net/";
	
	@Autowired
	CallRepository repo;
	
	@GetMapping("/movies")
	public ResponseEntity<Object> getMovies(){
		String uri = "movies/getAll";
		RestTemplate t = new RestTemplate();
	    String result = t.getForObject(uri, String.class);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/shows")
	public ResponseEntity<Object> getShows(){
		return new ResponseEntity<>("Bye!", HttpStatus.OK);
	}
	
	@GetMapping("/tickets")
	public ResponseEntity<Object> getTickets(){
		return new ResponseEntity<>("Bye!", HttpStatus.OK);
	}

}
