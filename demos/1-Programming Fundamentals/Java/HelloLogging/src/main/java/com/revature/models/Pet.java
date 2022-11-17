package com.revature.models;

import java.util.List;
//(ctrl + shift + o = auto add the imports into your java class)
import java.util.Objects;

public class Pet {
	
	public String name;
	public int age;
	public String breed;
	public List<String> hobbies;
	
	public Pet() {
		
	}

	public Pet(String name, int age, String breed, List<String> hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", age=" + age + ", breed=" + breed + ", hobbies=" + hobbies + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, breed, hobbies, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return age == other.age && Objects.equals(breed, other.breed) && Objects.equals(hobbies, other.hobbies)
				&& Objects.equals(name, other.name);
	}

}
