package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Blog;
import com.revature.models.User;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<Blog, Integer>{
	//update by blog id
	@Query(value="UPDATE blogs SET blog_title=?1, blog_subject=?2, blog_body=?3, blog_categories=?4 WHERE blog_id=?5", nativeQuery=true)
	public boolean update(String username, String password, String firstname, String lastname, String email, int id);
	
	//TODO: Will make a method to update blog by using owner's id in BlogRepository - must test query in dbeaver first
	@Query(value="UPDATE blogs SET blog_title=?1, blog_subject=?2, blog_body=?3, blog_categories=?4 WHERE blog_id=?5", nativeQuery=true)
	public boolean updateByOwnerId();
	
	
	@Query(value="SELECT * FROM blogs WHERE blog_id=?1", nativeQuery=true)
	public User findById(int id);
}
