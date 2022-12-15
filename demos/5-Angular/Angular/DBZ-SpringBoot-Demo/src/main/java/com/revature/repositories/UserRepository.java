package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
	//TODO: must call update blog first before running logic in this method to avoid fk violations
	//this update will skip the blogs - blogrepo will handle that update separately
	@Query(value="UPDATE users SET username=?1, user_password=?2, user_firstname=?3, user_lastname=?4, user_email=?5 WHERE user_id=?6", nativeQuery=true)
	public boolean update(String username, String password, String firstname, String lastname, String email, int id);
	
// This is a built in Spring Data JPA method.  Don't overwrite it with a custom query	
//	@Query(value="SELECT * FROM users WHERE user_id=?1", nativeQuery=true)
//	public User findById(int id);
	
	@Query(value="select * from users where username=?1", nativeQuery = true)
	public User findByUsernameStartsWith(String username);
}
