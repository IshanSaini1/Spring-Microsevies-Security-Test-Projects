package com.example.agw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.agw.entity.Person;
import com.example.agw.repository.PersonRepository;

@RestController
public class Controller2 {

	@Autowired
	private PersonRepository repo;

	@GetMapping("/getById/{id1}/{id2}")
	public List<Person> getPersonById(@PathVariable("id1") long id1, @PathVariable("id2") long id2) {
		return repo.find2Mains(id1, id2);
	}

	@GetMapping("/get/{id}")
	public Person get(@PathVariable("id") long id) {
		Person p2 = repo.findById(id).get();
		return p2;
	}

	@GetMapping("/test/{id}")
	public String test(@PathVariable("id") long id) throws Exception {
		boolean i = true;
		if (i) {
			throw new Exception();
		}
		return "Test  " + id;
	}
	
	@PostMapping("/post")
	public Person savePerson(@RequestBody Person p1) {
		p1.setId(0);
		return repo.save(p1);
	}

	@ExceptionHandler
	public ResponseEntity<String> errorHasOccurred(Exception e) {
		ResponseEntity<String> resp = new ResponseEntity<String>("Some Error has Occurred !!", HttpStatus.BAD_REQUEST);
		return resp;
	}
}
