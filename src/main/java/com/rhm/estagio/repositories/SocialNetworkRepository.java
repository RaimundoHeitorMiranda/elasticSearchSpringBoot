package com.rhm.estagio.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.rhm.estagio.models.SocialNetwork;

@Repository
public interface SocialNetworkRepository extends ElasticsearchRepository<SocialNetwork, String>{

	Optional<SocialNetwork> findByName(String name);
	
	void deleteByName(String Name);
	
	
}
