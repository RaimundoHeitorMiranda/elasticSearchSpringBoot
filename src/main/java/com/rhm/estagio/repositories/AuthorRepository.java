package com.rhm.estagio.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.rhm.estagio.models.Author;

@Repository
public interface AuthorRepository extends ElasticsearchRepository<Author, String> {

	Optional<Author> findByIdAndSocialNetwork(String id, String socialNetworkName);
	
	Optional<Author> findByNameAndSocialNetwork(String name, String socialNetworkName);
	
	Iterable<Author> findAllBySocialNetwork(String socialNetwork);
	
}
