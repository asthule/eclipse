package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Teacher;

public class HibernateUtil {



	

		
		private static SessionFactory sessionFactory;
		
		public static SessionFactory buildSessionFactory() {
			if(sessionFactory==null) {
				Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Class.class).addAnnotatedClass(Teacher.class).addAnnotatedClass(Subject.class);
				
				sessionFactory = config.buildSessionFactory();
				
			}
			return sessionFactory;
	}
	}

