package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Pet;

public class PetStoreImpl implements PetStore{
	
	public static Logger logger = LoggerFactory.getLogger(PetStoreImpl.class);
	
	//Arraylists are dynamic, resizable arrays. The size can be expanded/widened depending our application needs
	public List<Pet> pets = new ArrayList<Pet>();
	
	public List<String> hobbies = new ArrayList<String>();

	@Override
	public String addNewPet(Pet pet) {
		logger.debug("Hello logger, trying to add a pet...");
		
		//add a new Pet to our list
		pets.add(pet);
		
		//return that pet's name
		return pet.getName();
	}

	@Override
	public String addHobby(String hobby) {
		//logger.warn("BAD MOJO!");
		logger.debug("User is adding a new hobby to this pet's routine...");
		
		//add hobby to the list
		hobbies.add(hobby);
		
		//print the hobby name to exit
		return hobby;
	}

	@Override
	public void speakToCustomer() {
		logger.debug("Speaking to customer...");
		System.out.println("Hello customer");
	}

}
