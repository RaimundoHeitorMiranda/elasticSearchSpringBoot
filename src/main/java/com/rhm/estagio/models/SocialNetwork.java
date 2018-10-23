package com.rhm.estagio.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "socialnetwork", type = "social")
public class SocialNetwork {
	
	@Id
	private String id;
	
	private String name;

	public SocialNetwork () {
		
	}

	public SocialNetwork(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SocialNetwork [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
