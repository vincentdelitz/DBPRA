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

import com.sun.corba.se.pept.transport.Connection;

import de.tum.in.dbpra.model.bean.ProductListBean;
import de.tum.in.dbpra.model.dao.DAO;
import de.tum.in.dbpra.model.dao.OfferDAO;
import de.tum.in.dbpra.model.dao.ProductDAO;
import de.tum.in.dbpra.model.dao.SuperDAO;

/**
 * Servlet implementation class InsertProductServlet3
 */
@WebServlet("/InsertProductServlet3")
public class InsertProductServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet3() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int shopID = Integer.parseInt(request.getParameter("shopID"));
		String name = request.getParameter("name");
		String type = request.getParameter("producttype");
		double price = Double.parseDouble(request.getParameter("price"));
		try {
						
			SuperDAO sup = new SuperDAO();
			sup.insertProductAndOffer(quantity, shopID, name, type, price);
//			int productID = product.insertProduct(request.getParameter("name"), request.getParameter("producttype"), Double.parseDouble(request.getParameter("price")));
//			
//			OfferDAO offer = new OfferDAO();
//			offer.insertOffer(productID, shopID, quantity);
			
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
