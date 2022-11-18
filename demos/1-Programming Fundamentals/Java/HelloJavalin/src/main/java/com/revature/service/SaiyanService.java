package com.revature.service;

import com.revature.dao.SaiyanDAO;
import com.revature.models.Saiyan;

public class SaiyanService {
	//because this class will use the dao methods in SaiyanDAO, we will need an instance of SaiyanDAO here
	private static SaiyanDAO saiyanDao = new SaiyanDAO();
	
	public boolean addNewSaiyan(Saiyan saiyan) throws Exception {
		if(saiyanDao.addSaiyan(saiyan) != 0) {
			return true;
		}
		
		throw new Exception("My custom exception thrown");
		
		//this is a teriary operation
		//return (saiyanDao.addSaiyan(saiyan) != 0) ? true : false;
	}

}
