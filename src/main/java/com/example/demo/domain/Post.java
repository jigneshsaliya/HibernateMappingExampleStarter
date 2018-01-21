package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.example.demo.domain.PostDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="posts", catalog="test")
public class Post {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Long id; 
	
	@Column(name="post_title")
	private String postTitle; 
	
	@OneToOne(mappedBy="post", fetch=FetchType.LAZY,cascade=CascadeType.ALL,optional=false)
	private PostDetails postDetails;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="post_id")
	@JsonIgnore
	private List<PostCommnets> listOfComments = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY)
	public List<PostCommnets> getListOfComments() {
		return listOfComments;
	}

	public void setListOfComments(List<PostCommnets> listOfComments) {
		this.listOfComments = listOfComments;
	}

	public void addDetails(PostDetails postDetails) {
		this.postDetails = postDetails;
		postDetails.setPost(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public PostDetails getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(PostDetails postDetails) {
		this.postDetails = postDetails;
	}
	
 }
