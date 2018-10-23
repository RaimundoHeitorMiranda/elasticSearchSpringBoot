package com.rhm.estagio.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhm.estagio.models.Author;
import com.rhm.estagio.models.PostModel;
import com.rhm.estagio.models.SetUploadModel;
import com.rhm.estagio.models.SocialNetwork;
import com.rhm.estagio.repositories.AuthorRepository;
import com.rhm.estagio.repositories.PostRepository;
import com.rhm.estagio.repositories.SocialNetworkRepository;
import com.rhm.estagio.response.Response;
import com.rhm.estagio.services.AuthorService;
import com.rhm.estagio.services.PostService;
import com.rhm.estagio.services.SocialNetworkService;

@RestController
@RequestMapping("config")
@CrossOrigin("*")
public class UploadController {

	
	@Autowired
	private SocialNetworkService networkService;
	
	@Autowired
	private AuthorService authorService; 
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private SocialNetworkRepository networkRepository;
	
	@Autowired
	private AuthorRepository authorRepository; 
	
	@Autowired
	private PostRepository postRepository;
	
	
	@GetMapping("/reset")
	public void restore() {
		this.postRepository.deleteAll();
		this.authorRepository.deleteAll();
		this.networkRepository.deleteAll();
	}
	
	
	@PostMapping("/dataSetUpload")
	public ResponseEntity<Response<String>> uploadDatSet(@RequestParam("file") MultipartFile file) throws IOException{
		Response<String> response = new Response<String>();
		
		String fileData = "";
				
		fileData += "content type: " + file.getContentType() + " | ";
		fileData += "name: " + file.getName() + " | ";		
		fileData += "original File name: " + file.getOriginalFilename() + " | ";
		fileData += "size :" + file.getSize() + " | ";
		fileData += "InputStream: " + file.getInputStream() + " | ";
		fileData += "tostring :" + file.toString() + " | ";
		
		ObjectMapper objectMapper = new ObjectMapper();
		SetUploadModel dataSetUpload = objectMapper.readValue(file.getBytes(), SetUploadModel.class);
		List<PostModel> posts = dataSetUpload.getData();
		
		addSocialNetwork(posts);
		
		importAll(posts);		
        
		fileData += "tamanho: " + posts.size();
        response.setData(fileData);   
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	private void importAll(List<PostModel> posts) {
		
		for (int i = 0; i < posts.size(); i++) {
			try {
				String socialNetworkName = posts.get(i).getOrigin();
				Author author = posts.get(i).getAuthor();
				PostModel post = posts.get(i);
				
				//register and get author
				Author authorBd = this.authorService.getAuthor(author, socialNetworkName);
				
				//add Post
				this.postService.register(post, socialNetworkName, authorBd.getId());
				
				System.out.println("Social: " + socialNetworkName + " | Author name: " + author.getName() + " | AuthorBdId" + authorBd.getId() + " | post sentiment " + post.getSentiment());
			} catch (Exception e) {
				System.out.println("Exception found!");
			}

		}
		
	}

	private void addSocialNetwork(List<PostModel> posts) {
		
		for (int i = 0; i < posts.size(); i++) {
			if(! this.networkService.existsByName(posts.get(i).getOrigin())) {
				System.out.println("NEW SOCIAL NETWORK ADD: " + posts.get(i).getOrigin());
				this.networkService.register(new SocialNetwork(posts.get(i).getOrigin()));			
			}else {
				System.out.println("Already Exists: " +posts.get(i).getOrigin());				
			}
		}
		
	}
	
	
}
