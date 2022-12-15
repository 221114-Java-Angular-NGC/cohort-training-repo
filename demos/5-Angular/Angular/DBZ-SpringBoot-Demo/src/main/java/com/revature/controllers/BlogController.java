package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Blog;
import com.revature.models.ClientMessage;
import com.revature.services.BlogService;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins= {"http://localhost:4200"})
public class BlogController {
	
	@Autowired
	private BlogService blogServ;
	
	@PostMapping("/{id}")
	public ClientMessage createNewPost(@RequestBody Blog blog,  @PathVariable("id") int id) {
		return blogServ.createNewBlogPost(blog, id) != null ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}

	@GetMapping("/view-all")
	public List<Blog> getAllBlogs(){
		return blogServ.getAllBlogs();
	}
}
