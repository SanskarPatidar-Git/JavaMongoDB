package com.java.mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/*
 * This Aggregation works when MongoDB Atlas is Configured.
 */

@Component
public class PostSearchRepoImpl implements PostSearchRepo{

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;
	
	@Override
	public List<PostDto> search(String text) {
	
		List<PostDto> posts = new ArrayList<PostDto>();
		
			MongoDatabase database = mongoClient.getDatabase("test");
			MongoCollection<Document> collection = database.getCollection("post");
			AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("text", 
			    new Document("query", text)
			                .append("path", Arrays.asList("role", "description")))), 
			    new Document("$limit", 2L)));
			
			result.forEach(document -> posts.add(converter.read(PostDto.class, document)));
		return posts;
	}

}
