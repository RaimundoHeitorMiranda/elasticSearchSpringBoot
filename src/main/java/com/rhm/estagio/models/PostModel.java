package com.rhm.estagio.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "posts", type = "post")
public class PostModel {
	
	@Id
    private String id;
    
	private String content;
    private String rt;
    private String sentiment;
    private String service;
    @Field(type = FieldType.Nested)
    private Author author;
    private List<String> urls = new ArrayList<String>();
    private String application;
    private String origin;
    private Boolean replied;
    private Long count;
    private String collected_time;
    private String date;
    private String url;
    
    private List<String> hashtags = new ArrayList<String>();
    private Integer likes;
    private Integer replies;
    private String link;
    private Integer reach;
    private Integer impressions;
    private Integer comments_amounts;
    
    private String authorId;
    
//    private String elasticsearch_id;
//    private String elasticsearch_routing;
//    private String picture_full_size;
//    private String elasticsearch_index;
    
	public PostModel() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Boolean getReplied() {
		return replied;
	}

	public void setReplied(Boolean replied) {
		this.replied = replied;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getCollected_time() {
		return collected_time;
	}

	public void setCollected_time(String collected_time) {
		this.collected_time = collected_time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getReplies() {
		return replies;
	}

	public void setReplies(Integer replies) {
		this.replies = replies;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getReach() {
		return reach;
	}

	public void setReach(Integer reach) {
		this.reach = reach;
	}

	public Integer getImpressions() {
		return impressions;
	}

	public void setImpressions(Integer impressions) {
		this.impressions = impressions;
	}

	public Integer getComments_amounts() {
		return comments_amounts;
	}

	public void setComments_amounts(Integer comments_amounts) {
		this.comments_amounts = comments_amounts;
	}
	
	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String author_id) {
		this.authorId = author_id;
	}

	@Override
	public String toString() {
		return "PostModel [id=" + id + ", content=" + content + ", rt=" + rt + ", sentiment=" + sentiment
				+ ", service=" + service + ", author=" + author + ", urls=" + urls + ", application=" + application
				+ ", origin=" + origin + ", replied=" + replied + ", count=" + count + ", collected_time="
				+ collected_time + ", date=" + date + ", url=" + url + ", hashtags="
				+ hashtags + ", likes=" + likes + ", replies=" + replies + ", link=" + link + ", reach=" + reach
				+ ", impressions=" + impressions + ", comments_amounts=" + comments_amounts + "]";
	}

}
