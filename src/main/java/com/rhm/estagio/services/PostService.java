package com.rhm.estagio.services;

import java.util.List;

import com.rhm.estagio.models.PostModel;

public interface PostService {

	PostModel register(PostModel post,String networkName,String authorId);
	
	PostModel getById(String id,String networkName,String authorId);
	
	List<PostModel> getAll(String networkName,String authorId);
	
	PostModel upadte(PostModel postUpdate,String id);
	
	void delete(String id);
	
}
