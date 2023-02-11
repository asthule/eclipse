package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Classes;
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Teacher;

/**
 * Servlet implementation class AddTeachers
 */
@WebServlet("/teachers-list")
public class AddTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeachers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=null;
		Classes clas = new Classes();
		clas.setId(Integer.parseInt(request.getParameter("classes1")));
		
		if(clas.getId()==1) {
			
			name="Artifical Intelligence";
		}
		
		else if(clas.getId()==2) {
			
			name="Java";
		}
		
		else if(clas.getId()==3) {
			
			name="Backendend Development";
		}
		
		else if(clas.getId()==4) {
			
			name="Frontend Development";
		}
		
		else if(clas.getId()==5) {
			
		    name="SQL";
		}
		
		clas.setName(name);
		
		Teacher teach = new Teacher();
		
		String name2 = null;
	
		teach.setId(Integer.parseInt(request.getParameter("teacher")));
		
		if(teach.getId()==1){
			
			name2="Shweta";
		}
		
		else if(teach.getId()==2) {
			
			name2="Sneha";
		}
		
		else if(teach.getId()==3) {
			
			name2="Priyanka";
		}
		
		else if(teach.getId()==4) {
			
			name2="Neela";
		}
		
		else if(teach.getId()==5) {
			
			name2="Renuka";
		}
	
		
		teach.setName(name2);
		
		
		Subject subject1= new Subject();
		Subject subject2= new Subject();
		Subject subject3= new Subject();
		Subject subject4= new Subject();
		Subject subject5= new Subject();
		
		
		teach.getCla().add(clas);
		clas.setTeacher(name2);
		String[] checkbox;
		checkbox = request.getParameterValues("subject");
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Class.class).addAnnotatedClass(Teacher.class).addAnnotatedClass(Subject.class);
		
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		for(int i = 0;i<checkbox.length;i++) {
			
			PrintWriter out = response.getWriter();
			out.println("top"+checkbox[i]);
			
			if(checkbox[i].equals("1")) {
				
				out.println(checkbox[i]);
				subject1.setId(1);
				subject1.setName("OOPS");
				clas.getSub().add(subject1);
				subject1.setClas(clas);
				session.save(subject1);
			}
			
			else if(checkbox[i].equals("2")) {
				
				out.println(checkbox[i]);
				subject2.setId(2);
				subject2.setName("Core Java");
				clas.getSub().add(subject2);
				subject2.setClas(clas);
				session.save(subject2);
			}
			
			else if(checkbox[i].equals("3")) {
				
				out.println(checkbox[i]);
				subject3.setId(3);
				subject3.setName("HTML,CSS,Javascript");
				clas.getSub().add(subject3);
				subject3.setClas(clas);
				session.save(subject3);
			}
			
			else if(checkbox[i].equals("4")) {
				
				out.println(checkbox[i]);
				subject4.setId(4);
				subject4.setName("Data Structures");
				clas.getSub().add(subject4);
				subject4.setClas(clas);
				session.save(subject4);
			}
			
			else if(checkbox[i].equals("5")) {
				
				out.println(checkbox[i]);
				subject5.setId(1);
				subject5.setName("MySQL");
				clas.getSub().add(subject5);
				subject5.setClas(clas);
				session.save(subject5);
			}
			
			session.save(clas);
			session.save(teach);
			
			session.save(subject1);
			session.save(subject2);
			session.save(subject3);
			session.save(subject4);
			session.save(subject5);
			
			
			
			tx.commit();
		}
		
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
