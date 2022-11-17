package com.revature.drivers;

import java.util.ArrayList;

import com.revature.models.Pet;
import com.revature.services.PetStoreImpl;

public class MainDriver {

	public static void main(String[] args) {
		PetStoreImpl petStore = new PetStoreImpl();
		
		petStore.addNewPet(new Pet("Fido", 3, "Hound Dog", new ArrayList<String>()));

	}

}
