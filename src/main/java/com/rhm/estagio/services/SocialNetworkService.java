package com.rhm.estagio.services;

import java.util.List;

import com.rhm.estagio.models.SocialNetwork;

public interface SocialNetworkService {

	
	SocialNetwork  register(SocialNetwork social);
	
	SocialNetwork getById(String id);
	
	SocialNetwork getByName(String name);
	
	List<SocialNetwork> getAll();
	
	SocialNetwork update(SocialNetwork updateSocial,String name);
	
	void delete(String name);
	
	Boolean existsByName(String name);
	
}
