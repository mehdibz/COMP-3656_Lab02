package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Greeting
 */
//@WebServlet(name="/Greeting", urlPatterns="/Greeting" )
public class Greeting extends HttpServlet {
	String greetingMsg;
	String instructionMsg;
	private static final String header =  "<!DOCTYPE html>" 
										+ "<html>"
										+ "<head>" 
										+ "<meta charset='ISO-8859-1'>"
										+ "<title>Insert title here</title>"
										+ "</head>"
										+ "<body>";
	private static final String footer ="</body> </html>";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greeting() {
        super();
    }

	 public void init()
	 {
		 instructionMsg = getInitParameter("instructionMessage");
		 greetingMsg = getInitParameter("greetingMessage");
	 }

	 /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name;
		name=request.getParameter("nameField");
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = new Date();
	    PrintWriter out = response.getWriter();
	    
	    
		if( name== null || "".equals(name)) {
			 
			    out.println(header
						    + "<form name='nameForm' method='post' action='Greeting'>"
						    + "<div style='text-align:center'>"
							+ "<h2>"+instructionMsg+"</h2>"
							+ "<input type=text name='nameField' value=''>&nbsp"
							+ "<input type='submit' name='Submit' value='Submit'/>"
							+ "</div>"
							+ "</form>"
						    + footer);
			
		}else {
		   
		    out.println(header
					    + "<h2 style='text-align:center'>Hello "+name+"</h2>"
					    + "<h2 style='text-align:center'>"+greetingMsg+"</h2>"
					    + "<br>"
					    + "<br>"
					    + "<h3 style='text-align:center'>The current time is:</h3>"
					    + "<h3 style='text-align:center'>"+formatter.format(date)+"</h3>"
					    + "<br>"
					    + footer);
		}
	}
	
	public int testPasword(String text) {
		if(text.length()>5) {
			return text.length();
		}
		
		return 0;
		
	}
}
