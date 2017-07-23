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
		int quantity = 0;
		try {
		quantity = Integer.parseInt(request.getParameter("quantity"));
		} catch (Exception e) {
			request.setAttribute("error", "Invalid parameter (quantity)");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
			dispatcher.forward(request, response);
		}
		int shopID = 0;
		try {
		shopID = Integer.parseInt(request.getParameter("shopID"));
		} catch (Exception e) {
			request.setAttribute("error", "Invalid parameter (shopID)");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
			dispatcher.forward(request, response);
		}
		
		String name = request.getParameter("name");
		String type = request.getParameter("producttype");
		
		Double price = 1.00;
		try {
			price = Double.parseDouble(request.getParameter("price"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
    		request.setAttribute("error", "Invalid decimal (price)");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
			dispatcher.forward(request, response);
		}
		String[] splitter = price.toString().split("\\.");
		int decimalLength = splitter[1].length();  // After Decimal Count
		if (decimalLength > 2) {
    		request.setAttribute("error", "Invalid decimal (price): too many decimals specified");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
			dispatcher.forward(request, response);
		}
		
		try {
						
			SuperDAO sup = new SuperDAO();
			sup.insertProductAndOffer(quantity, shopID, name, type, price);
			
			ProductListBean productList = new ProductListBean();
			ProductDAO product = new ProductDAO();
			product.getProductsForShop(productList, shopID);
			request.setAttribute("bean",productList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("successfulInsert.jsp");
			dispatcher.forward(request, response);
	
		} catch (Throwable e) {
			String errormessage = e.getMessage();
			if (errormessage == "error1") {
				request.setAttribute("error", "There is no Shop with ID: " + shopID + "!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
				dispatcher.forward(request, response);
			} else if (errormessage == "error2") {
				request.setAttribute("error", "You already offer that Product");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
				dispatcher.forward(request, response);
			} else if (errormessage == "error3") {
				request.setAttribute("error", "The Product  " + name + " does already exist!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/insertProduct.jsp");
				dispatcher.forward(request, response);
			} else if (errormessage == "error4") {
				request.setAttribute("error", "The Price must be more than 0!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
				dispatcher.forward(request, response);
			} else if (errormessage == "error5") {
				request.setAttribute("error", "The Price must be less than 1000!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
				dispatcher.forward(request, response);
			} else if (errormessage == "error6") {
				request.setAttribute("error", "Please enter an name!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/enterProduct.jsp");
				dispatcher.forward(request, response);
				
			} else {
				request.setAttribute("error", errormessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("successfulInsert.jsp");
				dispatcher.forward(request, response);
			}		
		}

	}

}
