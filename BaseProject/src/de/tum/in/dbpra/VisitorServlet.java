package de.tum.in.dbpra;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tum.in.dbpra.model.bean.StageListBean;
import de.tum.in.dbpra.model.bean.VisitorBean;
import de.tum.in.dbpra.model.dao.StageDAO;

@WebServlet("/VisitorServlet")
public class VisitorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/VisitorSearch.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			StageDAO dao = new StageDAO();
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			
			HttpSession session = request.getSession();
			session.setAttribute("firstname", firstname);
			session.setAttribute("lastname", lastname);
			
			StageListBean stages = new StageListBean();
			dao.getPersonalStages(stages, firstname, lastname);
			request.setAttribute("stages", stages);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VisitorSearch.jsp");
			dispatcher.forward(request, response);

		} catch (Throwable e) {
			String errormessage = e.getMessage();
			if (errormessage == "error1") {
				request.setAttribute("error", "There is no Visitor with name: " + request.getParameter("firstname") + " " + request.getParameter("lastname") + "! Please try again!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VisitorSearch.jsp");
				dispatcher.forward(request, response);
			} else if (errormessage == "error2") {
				request.setAttribute("error", "There are Several Visitor with your name, " + request.getParameter("firstname") + " " + request.getParameter("lastname") + "! Please enter your visitor ID aswell!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VisitorSearchByID.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("error", errormessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VisitorSearch.jsp");
				dispatcher.forward(request, response);
			}
		}

			

	}
}
