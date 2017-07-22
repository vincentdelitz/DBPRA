package de.tum.in.dbpra;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.ShiftBean;
import de.tum.in.dbpra.model.dao.ShiftDAO;

/**
 * Servlet implementation class ShiftServlet
 */
@WebServlet("/ShiftServlet2")
public class ShiftServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShiftServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ShiftSearchByID.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
        	ShiftDAO dao = new ShiftDAO();
        	ArrayList <ShiftBean> shiftList = new ArrayList <ShiftBean>();
        	String firstname = request.getParameter("firstname");
        	String lastname = request.getParameter("lastname");
        	if (request.getParameter("personID") == "") {
        		dao.getShiftByName(shiftList, firstname, lastname);
        		request.setAttribute("shiftList", shiftList);
        	} else {
        		int ID = Integer.parseInt(request.getParameter("personID"));
            	dao.getShiftByID(shiftList, ID, firstname, lastname);
            	request.setAttribute("shiftList", shiftList);
        	}
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/ShiftView.jsp");
    		dispatcher.forward(request, response);
        	
    	} catch (Throwable e) {
    		String errormessage = e.getMessage();
    		if (errormessage == "error1") {
    			request.setAttribute("error1", e.getMessage());
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/ShiftSearchByName.jsp");
        		dispatcher.forward(request, response);
    		}
    		else if (errormessage == "error2")  {
    			request.setAttribute("error2", e.getMessage());
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/ShiftSearchByID.jsp");
        		dispatcher.forward(request, response);
    		} else if (errormessage == "error3") {
    			request.setAttribute("error3", e.getMessage());
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/ShiftSearchByID.jsp");
    			dispatcher.forward(request, response);
    		}
    	}
	}
}