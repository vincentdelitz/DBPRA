package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tum.in.dbpra.model.bean.StageListBean;
import de.tum.in.dbpra.model.dao.StageDAO;

/**
 * Servlet implementation class StageServlet
 */
@WebServlet("/StageServlet")
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

		
		try {

			StageDAO dao = new StageDAO();
			StageListBean stagelist = new StageListBean();
			dao.getPersonalStages(stagelist, request.getParameter("visitorID"));
			
			request.setAttribute("bean", stagelist);

		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/stageVisitor.jsp");
		dispatcher.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			StageDAO dao = new StageDAO();
			StageListBean stagelist = new StageListBean();
			dao.getPersonalStages(stagelist, request.getParameter("visitorID"));
		
			
			request.setAttribute("bean", stagelist);

		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/stageVisitor.jsp");
		dispatcher.forward(request, response);
	}

}
