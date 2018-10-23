package com.rhm.estagio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhm.estagio.models.Author;
import com.rhm.estagio.response.Response;
import com.rhm.estagio.services.AuthorService;

@RestController
@RequestMapping("/socialNetwork/{socialNetworkName}/author")
@CrossOrigin("*")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	
	@PostMapping
	public ResponseEntity<Response<Author>> register(@RequestBody Author author, @PathVariable String socialNetworkName){
	
		Response<Author> response = new Response<Author>();
			
		response.setData(this.authorService.register(author,socialNetworkName));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<List<Author>>> getAll(@PathVariable String socialNetworkName){
		
		Response<List<Author>> response = new Response<List<Author>>();
		
		response.setData(this.authorService.getAll(socialNetworkName));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Author>> getById(@PathVariable String id,@PathVariable String socialNetworkName){
	
		Response<Author> response = new Response<Author>();
		
		response.setData(this.authorService.getById(id,socialNetworkName));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<Author>> update(@RequestBody Author author,@PathVariable String id){
	
		Response<Author> response = new Response<Author>();
		
		response.setData(this.authorService.update(author,id));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable String id){
	
		Response<String> response = new Response<String>();
		this.authorService.delete(id);
		response.setData("Author removed with success");
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
	}
	
}
