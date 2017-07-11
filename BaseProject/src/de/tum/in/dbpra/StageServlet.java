package de.tum.in.dbpra;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.CustomerBean;
import de.tum.in.dbpra.model.bean.PartListBean;
import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.StageListBean;
import de.tum.in.dbpra.model.dao.CustomerDAO;
import de.tum.in.dbpra.model.dao.PartDAO;
import de.tum.in.dbpra.model.dao.StageDAO;

/**
 * Servlet implementation class StageServlet
 */
@WebServlet("/stage")
public class StageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/VisitorSearch.jsp");
		dispatcher.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		try {
			StageDAO stage = new StageDAO();
			StageListBean stagelist = new StageListBean();
			stage.getPersonalStages(stagelist, request.getParameter("firstname"), request.getParameter("lastname"));
			request.setAttribute("bean", stagelist);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
    		request.setAttribute("error", e.toString() + e.getMessage());
		}
		

			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/VisitorSearch.jsp");
		dispatcher.forward(request, response);
		
	}

}
