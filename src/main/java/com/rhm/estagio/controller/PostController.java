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

import com.rhm.estagio.models.PostModel;
import com.rhm.estagio.response.Response;
import com.rhm.estagio.services.PostService;

@RestController
@RequestMapping("/socialNetwork/{socialNetworkName}/author/{authorId}/posts")
@CrossOrigin("*")
public class PostController {

	@Autowired
	private PostService postService;
	
	
	@PostMapping
	public ResponseEntity<Response<PostModel>> register(@RequestBody PostModel post,
			@PathVariable String socialNetworkName,@PathVariable String authorId){
		
		Response<PostModel> response = new Response<PostModel>();
		
		response.setData(this.postService.register(post,socialNetworkName,authorId));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<PostModel>> getById(@PathVariable String id,
			@PathVariable String socialNetworkName,@PathVariable String authorId){
		
		Response<PostModel> response = new Response<PostModel>();

		response.setData(this.postService.getById(id,socialNetworkName,authorId));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping
	public ResponseEntity<Response<List<PostModel>>> getAll(@PathVariable String socialNetworkName,
			@PathVariable String authorId){
		
		Response<List<PostModel>> response = new Response<List<PostModel>>();

		response.setData(this.postService.getAll(socialNetworkName,authorId));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<PostModel>> upadte(@RequestBody PostModel postUpdate,@PathVariable String id){
		
		Response<PostModel> response = new Response<PostModel>();

		response.setData(this.postService.upadte(postUpdate, id));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable String id){

		Response<String> response = new Response<String>();
		this.postService.delete(id);
		response.setData("The post has been deleted");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);		
		
	}
	
}
