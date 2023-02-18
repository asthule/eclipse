package com.simplilearn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Admin;
import com.simplilearn.entity.PassengerDetails;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = null;
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(PassengerDetails.class).addAnnotatedClass(Admin.class);
		
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		List<Admin> ad = session.createQuery("from Admin").list();
		for(Admin a : ad)
		{
			
			password=a.getPassword();
		}
		
		
		if((request.getParameter("userid").equals("admin"))&&(request.getParameter("password").equals(password)))
		{
			
			List<PassengerDetails> list = session.createQuery("from PassengerDetails").list();
			for(PassengerDetails pd : list)
			{
				request.setAttribute("passengerName", pd.getPassengerName());
				request.setAttribute("emailId", pd.getEmailid());
				request.setAttribute("source", pd.getSource());
				request.setAttribute("destination", pd.getDestination());
				request.setAttribute("date", pd.getDate());
				request.setAttribute("airline", pd.getAirline());
				
				RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
				rd.forward(request, response);
				
				
				
			}
			
			Transaction tx = session.beginTransaction();
			
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
