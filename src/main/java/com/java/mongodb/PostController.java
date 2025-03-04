package com.java.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("getall")
	public List<PostDto> getAll(){
		return postService.getAll();
	}
	
	@PostMapping("save")
	public String save(@RequestBody PostDto post) {
		return postService.add(post);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		return postService.delete(id);
	}
	
	@GetMapping("get/{role}")
	public List<PostDto> getPostByRole(@PathVariable String role){
		return postService.getPostByRole(role);
	}
	
	@GetMapping("search/{text}")
	public List<PostDto> search(@PathVariable String text){
		return postService.search(text);
	}
	
}
