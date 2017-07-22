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
import de.tum.in.dbpra.model.dao.OfferDAO;
import de.tum.in.dbpra.model.dao.ProductDAO;

/**
 * Servlet implementation class InsertProductServlet2
 */
@WebServlet("/InsertProductServlet2")
public class InsertProductServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		System.out.println(productID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/enterShopID.jsp");
		dispatcher.forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shopID = Integer.parseInt(request.getParameter("shopID"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int productID = Integer.parseInt(request.getParameter("productID"));
		try {
			OfferDAO offer = new OfferDAO();
			offer.insertOffer(productID, shopID, quantity);

			ProductListBean productList = new ProductListBean();
			ProductDAO product = new ProductDAO();
			product.getProductsForShop(productList, shopID);
			request.setAttribute("bean",productList);

			
		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher("successfulInsert.jsp");
		dispatcher.forward(request, response);
	}

}
