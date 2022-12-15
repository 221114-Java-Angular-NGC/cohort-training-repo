package com.revature.services;

import java.util.List;

import com.revature.models.Blog;

public interface BlogService {

	//create blog
	public Blog createNewBlogPost(Blog blog, int userId);
	
	//get all blogs
	public List<Blog> getAllBlogs();
	
	//get blog by id
	public Blog getBlogByBlogId(int id);
	
	//get blogs by owner id - potential join statement
	public List<Blog> getBlogsByOwnerId(int ownerId);
	
	//get blogs by search term
	public List<Blog> getBlogsBySearchTerm(String searchTerm);
	
	//update blog
	public boolean updateBlog(Blog blog);
	
	//update owner of blog
	public boolean updateOwnerOfBlog(Blog blog, int ownerId);
	
	//delete blog
	public boolean deleteBlog(Blog blog);
}
