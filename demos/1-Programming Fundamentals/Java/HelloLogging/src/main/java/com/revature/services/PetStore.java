package com.revature.services;

import com.revature.models.Pet;

public interface PetStore {
	
	public String addNewPet(Pet pet);
	
	public String addHobby(String hobby);
	
	public void speakToCustomer();

}
