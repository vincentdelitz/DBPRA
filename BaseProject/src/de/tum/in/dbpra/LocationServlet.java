package de.tum.in.dbpra;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.LocationBean;
import de.tum.in.dbpra.model.dao.LocationDAO;

@WebServlet("/locationServlet")
public class LocationServlet extends HttpServlet {

	private static final long serialVersionUID = -7711999824595706896L;
	
	public LocationServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("product_id") != null &&
					request.getParameter("shop_id") != null){
				LocationDAO dao = new LocationDAO();
				ArrayList<LocationBean> locations = new ArrayList<LocationBean>();
				int productId = Integer.parseInt(request.getParameter("product_id"));
				int shopId = Integer.parseInt(request.getParameter("shop_id"));
				dao.getShopDetails(locations, productId, shopId);
				request.setAttribute("locations", locations);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/location.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
