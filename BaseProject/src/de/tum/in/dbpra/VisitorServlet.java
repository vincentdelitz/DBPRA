package de.tum.in.dbpra;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.VisitorBean;
import de.tum.in.dbpra.model.dao.VisitorDAO;

@WebServlet("/VisitorServlet")
public class VisitorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			VisitorDAO dao = new VisitorDAO();
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			ArrayList<VisitorBean> visitors = new ArrayList<VisitorBean>();
			visitors = dao.getVisitors(firstname, lastname);
			request.setAttribute("visitors", visitors);

		
	} catch (Throwable e) {
		e.printStackTrace();
		request.setAttribute("error", e.getMessage());
	}
	RequestDispatcher dispatcher = request
			.getRequestDispatcher("/selectVisitor.jsp");
	dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doPost(request, response);

	}
}
