package de.tum.in.dbpra;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.dao.offerDAO;
import de.tum.in.dbpra.model.bean.offerBean;
/**
 * Servlet implementation class offerServlet
 */
@WebServlet("/offerServlet")
public class offerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public offerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pname = (String) request.getParameter("name");
		try {
			offerDAO dao = new offerDAO();
			//get the result set(we store the 
			ArrayList<offerBean> offer = dao.getOffer(pname);
			//set the attribute of the request to pass it to jsp
			request.setAttribute("offer", offer);
		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error ", e.toString() + e.getMessage());
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/offer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
