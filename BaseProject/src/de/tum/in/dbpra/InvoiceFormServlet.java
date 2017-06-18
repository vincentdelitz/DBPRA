package de.tum.in.dbpra;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.CustomerBean;
import de.tum.in.dbpra.model.bean.LineitemListBean;
import de.tum.in.dbpra.model.bean.OrderBean;
import de.tum.in.dbpra.model.dao.CustomerDAO;
import de.tum.in.dbpra.model.dao.CustomerDAO.CustomerNotFoundException;
import de.tum.in.dbpra.model.dao.LineitemDAO;
import de.tum.in.dbpra.model.dao.OrderDAO;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		OrderDAO dao = new OrderDAO();
		OrderBean order = new OrderBean();
		order.setOrderkey(Integer.parseInt(request.getParameter("orderkey")));

		LineitemDAO ld = new LineitemDAO();
		LineitemListBean llb = new LineitemListBean();

		CustomerDAO cd = new CustomerDAO();
		CustomerBean cb = new CustomerBean();

		try {
			dao.getOrderById(order);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ld.getLineitemsByOrderkey(order, llb);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cb.setCustkey(order.getCustkey());
		try {
			cd.getCustomerById(cb);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Hier koennte man auch noch ein Attributliste für parts einfuegen um
		// den Namen herauszufinden der gekauften Teile

		request.setAttribute("order", order);
		request.setAttribute("lineitems", llb);
		request.setAttribute("customer", cb);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/exercise74.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
