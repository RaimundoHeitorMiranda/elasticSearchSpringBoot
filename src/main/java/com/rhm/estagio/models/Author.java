package com.rhm.estagio.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "authors", type = "author")
public class Author {
	
	@Id
	private String id;
	
	private String socialNetwork;
	private String name;
    private String description;
    private String location;
    private String gender;
    private String profile_image_url;
    private String login;
    private Integer tweets_count;    
    private Integer tweets;
    private Integer followers;
    private Integer friends;
    
    public Author() {
    	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getTweets_count() {
		return tweets_count;
	}

	public void setTweets_count(Integer tweets_count) {
		this.tweets_count = tweets_count;
	}

	public Integer getTweets() {
		return tweets;
	}

	public void setTweets(Integer tweets) {
		this.tweets = tweets;
	}

	public Integer getFollowers() {
		return followers;
	}

	public void setFollowers(Integer followers) {
		this.followers = followers;
	}

	public Integer getFriends() {
		return friends;
	}

	public void setFriends(Integer friends) {
		this.friends = friends;
	}	
	
	public String getSocialNetwork() {
		return socialNetwork;
	}

	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", gender=" + gender + ", profile_image_url=" + profile_image_url + ", login=" + login
				+ ", tweets_count=" + tweets_count + ", tweets=" + tweets + ", followers=" + followers + ", friends="
				+ friends + "]";
	}

}
