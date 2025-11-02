package com.yash.Joblisting.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yash.Joblisting.model.Post;

public interface PostRepository extends  MongoRepository<Post,String>
{
	
}
