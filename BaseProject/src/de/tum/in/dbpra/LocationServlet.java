package de.tum.in.dbpra;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.offerBean;
import de.tum.in.dbpra.model.dao.offerDAO;

@WebServlet("/locationServlet")
public class LocationServlet extends HttpServlet {

	private static final long serialVersionUID = -7711999824595706896L;
	
	public LocationServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pname = (String) request.getParameter("name");
		try {
			// locationDAO dao = new locationDAO();
			//get the result set
			// ArrayList<locationBean> locations = dao.getLocation(pname);
			//set the attribute of the request to pass it to jsp
			// request.setAttribute("locations", locations);
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
