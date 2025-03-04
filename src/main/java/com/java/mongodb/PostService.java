package com.java.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	PostRepository repository;
	
	@Autowired
	PostSearchRepoImpl searchImpl;
	
	@Autowired
	AggregationImpl aggregationImpl;
	
	public List<PostDto> getAll(){
		return repository.findAll();
	}
	
	public String add(PostDto post) {
		repository.save(post);
		return "SUCCESS";
	}
	
	public String delete(String id) {
		repository.deleteById(id);
		return "Item removed";
	}
	
	public List<PostDto> getPostByRole(String role){
		return repository.getPostByRole(role);
	}
	
	public List<PostDto> search(String text){
		return aggregationImpl.searchPosts(text);
	}
}
