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

import de.tum.in.dbpra.model.bean.OfferProductBean;
import de.tum.in.dbpra.model.dao.OfferProductDAO;

/**
 * Servlet implementation class OfferProductServlet
 */
@WebServlet("/OfferProductServlet")
public class OfferProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchProduct.jsp");
		dispatcher.forward(request, response);
    	
//		String pname = (String) request.getParameter("name");
//		try {
//			HttpSession session = request.getSession();
//			OfferProductDAO dao = new OfferProductDAO();
//			ArrayList<OfferProductBean> offers = dao.getOffer(pname);
//			session.setAttribute("offers", offers);
//			request.setAttribute("pname",pname);
//		} catch (Throwable e) {
//			e.printStackTrace();
//			request.setAttribute("error", e.getMessage());
//		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/offer.jsp");
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = (String) request.getParameter("name");
		try {
			HttpSession session = request.getSession();
			OfferProductDAO dao = new OfferProductDAO();
			ArrayList<OfferProductBean> offers = dao.getOffer(pname);
			session.setAttribute("offers", offers);
			request.setAttribute("pname",pname);
		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/offerProduct.jsp");
		dispatcher.forward(request, response);
	}


}