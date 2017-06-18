package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.CustomerBean;
import de.tum.in.dbpra.model.bean.OrderBean;
import de.tum.in.dbpra.model.dao.CustomerDAO;
import de.tum.in.dbpra.model.dao.OrderDAO;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/invoiceform")
public class InvoiceFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //testkommentar

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerSearch.jsp");
		dispatcher.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
        	OrderDAO dao = new OrderDAO();
        	OrderBean order = new OrderBean();
        	order.setOrderkey(Integer.parseInt(request.getParameter("orderkey")));
        	dao.getOrderById(order);
        	request.setAttribute("order", order)
    	} catch (Throwable e) {
    		e.printStackTrace();
    		request.setAttribute("error", e.toString() + e.getMessage());
    	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/exercise74.jsp");
		dispatcher.forward(request, response);
		
	}

}
