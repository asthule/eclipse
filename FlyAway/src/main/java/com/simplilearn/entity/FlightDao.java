package com.simplilearn.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FlightDao {

	public List<FlightDetails> searchFlights(String date,String source,String destination,String persons)
	
	{
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FlightDetails.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		tx.commit();
		
		List<FlightDetails> list = session.createQuery("from FlightDetails").list();
		return list;
	}
	
}
