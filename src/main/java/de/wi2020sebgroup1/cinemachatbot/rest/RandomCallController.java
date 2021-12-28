package de.wi2020sebgroup1.cinemachatbot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/random")
public class RandomCallController {
	
	@Autowired
	CallRepository repo;
	
	@GetMapping("/greeting")
	public ResponseEntity<Object> getRandomGreeting(){
		return new ResponseEntity<>("Hi!", HttpStatus.OK);
	}
	
	@GetMapping("/goodbye")
	public ResponseEntity<Object> getRandomGoodbye(){
		return new ResponseEntity<>("Bye!", HttpStatus.OK);
	}
	
}
