package de.wi2020sebgroup1.cinemachatbot.rest;

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
	
	@GetMapping("/movies")
	public ResponseEntity<Object> getMovies(){
		String uri = baseURL+"movie/getAll";
		RestTemplate t = new RestTemplate();
	    Object result = t.getForObject(uri, Object.class);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/shows")
	public ResponseEntity<Object> getShows(){
		String uri = baseURL+"show/getAll";
		RestTemplate t = new RestTemplate();
	    Object result = t.getForObject(uri, Object.class);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/tickets/{userID}")
	public ResponseEntity<Object> getTickets(){
		return new ResponseEntity<>("Not yet implemented", HttpStatus.NOT_IMPLEMENTED);
	}

}
