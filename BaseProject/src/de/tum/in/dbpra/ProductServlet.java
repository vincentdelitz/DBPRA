package de.tum.in.dbpra;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.ProductBean;
import de.tum.in.dbpra.model.dao.ProductDAO;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("product_name") != null){
				ProductDAO dao = new ProductDAO();
				String productName = request.getParameter("product_name");
				ArrayList<ProductBean> products = new ArrayList<ProductBean>();
				products = dao.getProductSearchResults(productName);
				request.setAttribute("products", products);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/selectProduct.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
