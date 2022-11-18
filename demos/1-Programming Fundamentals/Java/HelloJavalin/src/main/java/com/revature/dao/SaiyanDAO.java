package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Saiyan;

public class SaiyanDAO {
	private static List<Saiyan> myList = new ArrayList<>();
	private static int counter = 0;
	
	public int addSaiyan(Saiyan saiyan) {
		//for this example, I will be providing hardcoded values. This will be replaced with JDBC/SQL later.
		//add saiyan to list
		myList.add(saiyan);
		
		//return its new id number (simulated by the counter)
		return ++counter;
	}

}
