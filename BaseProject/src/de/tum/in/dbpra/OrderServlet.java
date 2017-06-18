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
import de.tum.in.dbpra.model.dao.OrderDAO;


/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		OrderDAO od = new OrderDAO();
		OrderListBean olb_ok = new OrderListBean();
		OrderDAO od_no = new OrderDAO();
		OrderListBean olb_no = new OrderListBean();
		//get All Orders

		try {
			od.getOkOrders(olb_ok);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			od_no.getNoOrders(olb_no);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

		request.setAttribute("bean", olb_ok);
		request.setAttribute("bean_no", olb_no);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("exercise72.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	

}
