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

import com.rhm.estagio.models.SocialNetwork;
import com.rhm.estagio.response.Response;
import com.rhm.estagio.services.SocialNetworkService;

@RestController
@RequestMapping("socialNetwork/")
@CrossOrigin("*")
public class SocialNetworkController {

	@Autowired
	private SocialNetworkService networkService;
	
	@PostMapping
	public ResponseEntity<Response<SocialNetwork>> register(@RequestBody SocialNetwork social){
		Response<SocialNetwork> response = new Response<SocialNetwork>();
		
		
		response.setData(this.networkService.register(social));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Response<SocialNetwork>> getByname(@PathVariable String name){
		Response<SocialNetwork> response = new Response<SocialNetwork>();
		
		response.setData(this.networkService.getByName(name));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<List<SocialNetwork>>> getAll(){
		Response<List<SocialNetwork>> response = new Response<List<SocialNetwork>>();
		
		response.setData(this.networkService.getAll());
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/{name}")
	public ResponseEntity<Response<SocialNetwork>> update(@RequestBody SocialNetwork socialUpadte,@PathVariable String name){
		Response<SocialNetwork> response = new Response<SocialNetwork>();
		
		response.setData(this.networkService.update(socialUpadte, name));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{name}")
	public ResponseEntity<Response<String>> delete(@PathVariable String name){
		Response<String> response = new Response<String>();
		this.networkService.delete(name);
		response.setData("SocialNetwork has been deleted");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
