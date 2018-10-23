package com.rhm.estagio.services.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhm.estagio.exceptions.ResourceNotFound;
import com.rhm.estagio.models.Author;
import com.rhm.estagio.models.SocialNetwork;
import com.rhm.estagio.repositories.AuthorRepository;
import com.rhm.estagio.repositories.SocialNetworkRepository;
import com.rhm.estagio.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private SocialNetworkRepository networkRepository;
	
	
	@Override
	public Author register(Author author,String socialNetworkName) {
		Optional<SocialNetwork> social = this.networkRepository.findByName(socialNetworkName);
		
		if(! social.isPresent()) {
			throw new ResourceNotFound("SocialNetwork not found");
		}
		
		author.setId(UUID.randomUUID().toString());
		author.setSocialNetwork(socialNetworkName);
		return this.authorRepository.save(author);
	}

	@Override
	public Author getById(String id,String socialNetworkName) {
		Optional<SocialNetwork> social = this.networkRepository.findByName(socialNetworkName);
		
		if(!social.isPresent()) {
			throw new ResourceNotFound("SocialNetwork not found");
		}
		 
		Optional<Author> author = this.authorRepository.findByIdAndSocialNetwork(id, socialNetworkName);  
		
		if(!author.isPresent()) {
			throw new ResourceNotFound("Author not found");
		}
		
		return author.get();
	}

	@Override
	public List<Author> getAll(String socialNetworkName) {
		Optional<SocialNetwork> social = this.networkRepository.findByName(socialNetworkName);
		
		if(!social.isPresent()) {
			throw new ResourceNotFound("SocialNetwork not found");
		}
		
		
		List<Author> list = new ArrayList<Author>();

		this.authorRepository.findAllBySocialNetwork(socialNetworkName).forEach(author -> list.add(author));
		return list;
	}

	@Override
	public Author update(Author authorUpdate,String id) {
		Optional<Author> authorBd = this.authorRepository.findById(id);
		
		if(! authorBd.isPresent()) {
			throw new ResourceNotFound("Author not found");
		}
		
		authorUpdate.setSocialNetwork(authorBd.get().getSocialNetwork());
		authorUpdate.setId(authorBd.get().getId());
		
		return this.authorRepository.save(authorUpdate);
	}

	@Override
	public void delete(String id) {
		Optional<Author> authorBd = this.authorRepository.findById(id);
		
		if(! authorBd.isPresent()) {
			throw new ResourceNotFound("Author not found");
		}
		
		this.authorRepository.deleteById(id);
	}

	@Override
	public Author getAuthor(Author author, String socialNetworkName) {
		Optional<SocialNetwork> social = this.networkRepository.findByName(socialNetworkName);
		
		if(! social.isPresent()) {
			throw new ResourceNotFound("SocialNetwork not found");
		}
		
		Optional<Author> authorBd = this.authorRepository.findByNameAndSocialNetwork(author.getName(), socialNetworkName);
		
		if(authorBd.isPresent()) {
			return authorBd.get();
		}
		
		author.setId(UUID.randomUUID().toString());
		author.setSocialNetwork(socialNetworkName);
		return this.authorRepository.save(author);
	}

	

}
