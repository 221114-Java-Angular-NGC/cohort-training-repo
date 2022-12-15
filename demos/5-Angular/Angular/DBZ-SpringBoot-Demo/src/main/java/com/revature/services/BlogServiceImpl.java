package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Blog;
import com.revature.models.User;
import com.revature.repositories.BlogRepository;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	private BlogRepository blogRepo;
	
	@Autowired
	private UserService userService;

	@Override
	public Blog createNewBlogPost(Blog blog, int userId) {
		
		Optional<User> user = userService.getUserById(userId);
		
		// if a User with that ID ACTUALLY exists in the DB...
		if (user.isPresent()) {
			// set the blog's owner property to the value of the user obj
			blog.setOwner(user.get());
		} else {
			// ideally customize this to be a cutom exception
			// throw new UserNotFoundException();
			System.out.println("No user found!");
		}
		
		return blogRepo.save(blog);

	}

	@Override
	public List<Blog> getAllBlogs() {
		return blogRepo.findAll();
	}

	@Override
	public Blog getBlogByBlogId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogsByOwnerId(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogsBySearchTerm(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOwnerOfBlog(Blog blog, int ownerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

}
