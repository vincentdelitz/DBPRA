package de.tum.in.dbpra;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.OrderListBean;
import de.tum.in.dbpra.model.bean.PartListBean;
import de.tum.in.dbpra.model.dao.OrderDAO;
import de.tum.in.dbpra.model.dao.PartDAO;


/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/part")
public class PartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PartDAO part = new PartDAO();
		PartListBean partlist = new PartListBean();
		PartDAO partsearch = new PartDAO();
		PartListBean partlistsearch = new PartListBean();

		try {
			part.getParts(partlist);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//partsearch.getPartsSearch(partlistsearch, request.getParameter("selectcolumn"), request.getParameter("searchtype"), request.getParameter("searchparameter"));
			partsearch.getPartsSearch(partlistsearch, "partkey", "exact", "4");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		request.setAttribute("bean", partlist);	
		request.setAttribute("beansearch", partlistsearch);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("exercise73.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	

}
