package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.models.Pet;
import com.revature.services.PetStoreImpl;

class PetStoreTest {

	@Test
	void addNewPetToStore() {
		//3 As in TDD - how would you create a JUnit test
		// ARRANGE - set up our test with needed objects
		// need a pet, petStoreImpl instance, arraylist of pets
		//usually the arrange step is taken care of in the BeforeAll/BeforeEach methods of your test suite
		Pet fido = new Pet("fido", 3, "dog", new ArrayList<String>());
		PetStoreImpl ps = new PetStoreImpl();
		ArrayList<Pet> pets = new ArrayList<>();
		
		// ACT - perform the test on the test method and get back the actual results
		String result = ps.addNewPet(fido);
		
		// ASSERT - compare actual results with what we expect as results 
		assertEquals("fido", result);
		
	}
	
	@Test
	void addHobbyToPet() {
		//hint: use PetStoreImpl's addHobby() method here to perform this test.
		
	}

}
