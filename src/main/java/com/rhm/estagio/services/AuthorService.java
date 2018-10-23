package com.rhm.estagio.services;

import java.util.List;

import com.rhm.estagio.models.Author;

public interface AuthorService {
	
	
	Author register(Author author,String socialNetworkName);
	
	Author getAuthor(Author author,String socialNetworkName);
	
	Author getById(String id,String socialNetworkName);
	
	List<Author> getAll(String socialNetworkName);
	
	Author update(Author authorUpdate, String id);
	
	void delete(String id);
	

}
