package com.yash.Joblisting.Repository;

import java.util.List;

import com.yash.Joblisting.model.Post;

public interface SearchRepository 
{
	List<Post> findByText(String text);
	
}
