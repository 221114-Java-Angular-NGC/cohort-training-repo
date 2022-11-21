package com.revature.service;

import com.revature.dao.SaiyanDAO;
import com.revature.models.Saiyan;

public class SaiyanService {
	//because this class will use the dao methods in SaiyanDAO, we will need an instance of SaiyanDAO here
	private static SaiyanDAO saiyanDao = new SaiyanDAO();
	
	public int addNewSaiyan(Saiyan saiyan){
		return saiyanDao.addSaiyan(saiyan);
	}

}
