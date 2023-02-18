package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.entity.FlightDao;
import com.simplilearn.entity.FlightDetails;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String htmldate = request.getParameter("date");
		
		SimpleDateFormat sd = new SimpleDateFormat("yy-mm-dd");
		
		long l = 0;
		
		try {
			l = sd.parse(htmldate).getTime();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		Date date = new Date(l);
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String persons = request.getParameter("persons");
		PrintWriter out = response.getWriter();
		FlightDao fd = new FlightDao();
		
		String flydate = new SimpleDateFormat("yy-mm-dd").format(date);
		
		for(FlightDetails dl:fd.searchFlights(flydate, source, destination, persons))
		{
	
			
			if((dl.getDate().equalsIgnoreCase(flydate))&&(dl.getSource().equals(source))&&(dl.getDestination().equals(destination)))
			{
				request.setAttribute("FlightId", dl.getFlightID());
				request.setAttribute("source", dl.getSource());
				request.setAttribute("destination", dl.getDestination());
				request.setAttribute("airline", dl.getAirline());
				request.setAttribute("price", dl.getPrice());
				request.setAttribute("persons", persons);
				request.setAttribute("date", flydate);
				RequestDispatcher rd = request.getRequestDispatcher("TicketPage.jsp");
				rd.forward(request, response);
		
			}
		}
		out.println("</table>");
		out.println("</body></html>");
		
		System.out.println("fly"+flydate);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
