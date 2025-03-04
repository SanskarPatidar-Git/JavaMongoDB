package com.java.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<PostDto, String>{

	@Query("{'role': ?0}")
	List<PostDto> getPostByRole(String role);
}
