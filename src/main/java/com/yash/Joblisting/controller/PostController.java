package com.yash.Joblisting.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.Joblisting.Repository.PostRepository;
import com.yash.Joblisting.Repository.SearchRepository;
import com.yash.Joblisting.model.Post;

import jakarta.servlet.http.HttpServletResponse;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class PostController {

	@Autowired
	PostRepository repo;
	
	
	@Autowired
	SearchRepository srepo;
	
	@ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        // Redirect to the new Springdoc Swagger UI page
        response.sendRedirect("/swagger-ui/index.html");
    }
	
	
    @GetMapping("/posts")
    public List<Post> getAllPosts()
    {
    	return repo.findAll();
    }
    
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text)
    {
    	return srepo.findByText(text);
    }
    
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
    	return repo.save(post);
    	
    	
    }
    
}

