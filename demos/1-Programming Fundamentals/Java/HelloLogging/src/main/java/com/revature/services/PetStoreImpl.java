package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Pet;

public class PetStoreImpl implements PetStore{
	
	public static Logger logger = LoggerFactory.getLogger(PetStoreImpl.class);

	@Override
	public String addNewPet(Pet pet) {
		logger.debug("Hello logger, trying to add a pet...");
		return pet.toString();
	}

	@Override
	public String addHobby(String hobby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void speakToCustomer() {
		// TODO Auto-generated method stub
		
	}

}
