package com.rhm.estagio.services.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhm.estagio.exceptions.ResourceNotFound;
import com.rhm.estagio.models.Author;
import com.rhm.estagio.models.PostModel;
import com.rhm.estagio.models.SocialNetwork;
import com.rhm.estagio.repositories.AuthorRepository;
import com.rhm.estagio.repositories.PostRepository;
import com.rhm.estagio.repositories.SocialNetworkRepository;
import com.rhm.estagio.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private SocialNetworkRepository networkRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	
	@Override
	public PostModel register(PostModel post,String networkName,String authorId) {
		
		Optional<SocialNetwork> network = this.networkRepository.findByName(networkName);
		
		if(!network.isPresent()) {
			throw new ResourceNotFound("SocialNetwork not found");
		}
		
		Optional<Author> author = this.authorRepository.findById(authorId);
		
		if(!author.isPresent()) {
			throw new ResourceNotFound("Author not found");
		}
		
		post.setId(UUID.randomUUID().toString());
		post.setAuthorId(authorId);
		post.setAuthor(author.get());
		post.setOrigin(networkName);
		
		return this.postRepository.save(post);
	}

	@Override
	public PostModel getById(String id,String networkName,String authorId) {
		
		Optional<SocialNetwork> network = this.networkRepository.findByName(networkName);
		if(!network.isPresent()) {
			throw new ResourceNotFound("SocialNetwork not found");
		}
		
		Optional<Author> author = this.authorRepository.findById(authorId);
		if(!author.isPresent()) {
			throw new ResourceNotFound("Author not found");
		}
		
		
		Optional<PostModel>  post = this.postRepository.findByIdAndOriginAndAuthorId(id, networkName, authorId);
		System.out.println(post.get());
		if(!post.isPresent()) {
			throw new RuntimeException();
		}
		
		return post.get();
		
	}

	@Override
	public List<PostModel> getAll(String networkName,String authorId) {
		
		Optional<SocialNetwork> network = this.networkRepository.findByName(networkName);
		if(!network.isPresent()) {
			throw new ResourceNotFound("SocialNetwork not found");
		}
		
		Optional<Author> author = this.authorRepository.findById(authorId);
		if(!author.isPresent()) {
			throw new ResourceNotFound("Author not found");
		}
		
		List<PostModel> postList = new ArrayList<PostModel>();
		System.out.println("AAA");
		this.postRepository.findAllByOriginAndAuthorId(networkName, authorId).forEach(post -> System.out.println(post));
		this.postRepository.findAllByOriginAndAuthorId(networkName, authorId).forEach(post -> postList.add(post));
		
		return postList;
	}

	@Override
	public PostModel upadte(PostModel postUpdate, String id) {
				
		Optional<PostModel> postDb = this.postRepository.findById(id);
		if(!postDb.isPresent()) {
			throw new ResourceNotFound("Post not found");
		}
		
		postUpdate.setId(postDb.get().getId());
		postUpdate.setAuthor(postDb.get().getAuthor());
		postUpdate.setAuthorId(postDb.get().getAuthorId());
		postUpdate.setOrigin(postDb.get().getOrigin());
		
		return this.postRepository.save(postUpdate);
	}

	@Override
	public void delete(String id) {
		Optional<PostModel> postDb = this.postRepository.findById(id);
		if(!postDb.isPresent()) {
			throw new ResourceNotFound("Post not found");
		}
		
		this.postRepository.deleteById(id);
	}

}
