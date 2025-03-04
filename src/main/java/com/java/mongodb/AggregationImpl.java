package com.java.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

/*
 * Aggregation for searching the keywords from multiple fields.
 */

@Component
public class AggregationImpl {

	@Autowired
    private MongoTemplate mongoTemplate;

    public List<PostDto> searchPosts(String keyword) {
        // Aggregation pipeline to search the keyword in location, role, or description
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(
                new Criteria().orOperator(
                    Criteria.where("locations").regex(keyword, "i"),  // "i" for case-insensitive match
                    Criteria.where("role").regex(keyword, "i"),
                    Criteria.where("description").regex(keyword, "i")
                )
            )//,Aggregation.limit(10) // Optional: Limit the number of documents returned
        );

        // Execute the aggregation
        return mongoTemplate.aggregate(aggregation, "post", PostDto.class).getMappedResults();
    }
}
