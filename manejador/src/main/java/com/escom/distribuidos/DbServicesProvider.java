package com.escom.distribuidos;

import com.escom.distribuidos.cliente.Cliente;
import com.escom.distribuidos.core.dao.BDEnum;

public class DbServicesProvider {

	private static MySqlServices mySqlServices;
	private static PostgressServices postgressServices;

	public static DBService getInstance(BDEnum dbType) {
		if (dbType.equals(BDEnum.MYSQL)) {
			if (mySqlServices == null)
				mySqlServices = new MySqlServices(Cliente.getInstance());
			return mySqlServices;
		} else if (dbType.equals(BDEnum.POSTGRES)) {
			if (postgressServices == null)
				postgressServices = new PostgressServices(Cliente.getInstance());
			return postgressServices;
		}
		return null;
	}

}
