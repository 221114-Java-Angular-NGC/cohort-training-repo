package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Demoing Lombok
 */

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {
	
//	private int id;
	private String name;
	private double calories;
	
	
}
