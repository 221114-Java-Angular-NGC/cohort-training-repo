package com.revature.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Fruit;

public interface FruitRepo extends JpaRepository<Fruit, Integer>{
	
	List<Fruit> findAll();
	
	Fruit findByName(String name);
	
	Fruit save(Fruit f);
	
	void delete(Fruit f);

}
