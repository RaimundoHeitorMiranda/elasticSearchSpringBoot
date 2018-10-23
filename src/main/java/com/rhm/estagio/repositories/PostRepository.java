package com.rhm.estagio.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.rhm.estagio.models.PostModel;

@Repository
public interface PostRepository extends ElasticsearchRepository<PostModel, String> {
	
	
	Optional<PostModel> findByIdAndOriginAndAuthorId(String id,String origin,String author);
	
	Iterable<PostModel> findAllByOriginAndAuthorId(String origin,String author_id); 

}
