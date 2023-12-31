package com.provider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	
	public static SessionFactory factory;
	
	public static SessionFactory getFactory() {
		
		if(factory==null) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		}
		
		
		return factory;
	}
	public void closeFactory(){
		if(factory.isOpen()) {
			factory.close();
		}
	}

}
