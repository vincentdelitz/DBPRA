package de.tum.in.dbpra;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tum.in.dbpra.model.bean.ProductListBean;
import de.tum.in.dbpra.model.dao.ProductDAO;


@WebServlet("/InsertProductServlet")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/enterShopID.jsp");
//		dispatcher.forward(request, response);	

		try {
			ProductDAO product = new ProductDAO();
			ProductListBean productlist = new ProductListBean();
			product.getProducts(productlist);
			request.setAttribute("bean",productlist);

		} catch (Throwable e) {
			e.printStackTrace();
    		request.setAttribute("error", e.toString() + e.getMessage());
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/insertProduct.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int shopID = Integer.parseInt(request.getParameter("shopID"));
//		HttpSession session = request.getSession();
//		session.setAttribute("shopID", shopID);

//		try {
//			ProductDAO product = new ProductDAO();
//			ProductListBean productlist = new ProductListBean();
//			product.getProducts(productlist);
//			request.setAttribute("bean",productlist);
//
//		} catch (Throwable e) {
//			e.printStackTrace();
//    		request.setAttribute("error", e.toString() + e.getMessage());
//		}	
//		RequestDispatcher dispatcher = request.getRequestDispatcher("insertProduct.jsp");
//		dispatcher.forward(request, response);
		


	}
	
	

}
