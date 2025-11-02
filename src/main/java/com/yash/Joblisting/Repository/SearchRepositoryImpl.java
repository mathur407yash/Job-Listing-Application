package com.yash.Joblisting.Repository;

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
import com.yash.Joblisting.model.Post;
@Component
public class SearchRepositoryImpl implements SearchRepository{

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;
	
	@Override
	public List<Post> findByText(String text) {
		// TODO Auto-generated method stub
	
		final List<Post> posts=new ArrayList<>();
		
	
			MongoDatabase database = mongoClient.getDatabase("yash");
			MongoCollection<Document> collection = database.getCollection("JobPost");
			AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("text", 
			    new Document("query", text)
			                .append("path", Arrays.asList("techs", "desc")))), 
			    new Document("$sort", 
			    new Document("exp", 1L)), 
			    new Document("$limit", 2L)));
//			 Below we are adding the posts into list but the data received from the database is in JSon format so we are converting it to java then we are adding it with thw help of MongoConverter and by traversing using foreach loop .
			result.forEach(doc->posts.add(converter.read(Post.class,doc)));
		
		return posts;
	}
	
 

}
