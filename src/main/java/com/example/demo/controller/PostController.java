package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Post;
import com.example.demo.domain.PostCommnets;
import com.example.demo.domain.PostDetails;
import com.example.demo.dao.PostRepository;

@RestController
public class PostController {
	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping(value="/getPost", method = RequestMethod.GET)
	public Post getAllPost(){
		Post post = postRepository.findOne(1L);
		//System.out.println(post.getListOfComments().size());
		return post; 
	}
	
	@RequestMapping(value="/addPost", method = RequestMethod.GET )
	public Post addPost() {
		Post post = new Post();
		post.setPostTitle("First post");
		PostDetails postDetails = new PostDetails();
		postDetails.setPostDescription("First psot description");
		post.addDetails(postDetails);
		//postDetails.setPost(post);
		
		PostCommnets comment1 = new PostCommnets();
		comment1.setCommentText("First comment.");
		
		PostCommnets commnet2 = new PostCommnets();
		commnet2.setCommentText("Second comment.");
		
		post.getListOfComments().add(comment1);
		post.getListOfComments().add(commnet2);
		
		Post post1 = postRepository.save(post);
		
		return post1;
	}
	
}
