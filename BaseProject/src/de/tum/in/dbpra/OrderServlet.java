package de.tum.in.dbpra;

import de.tum.in.dbpra.model.bean.CustomerBean;
import de.tum.in.dbpra.model.bean.OrderBean;
import de.tum.in.dbpra.model.dao.CustomerDAO;

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
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/exercise72.jsp");
		dispatcher.forward(request, response);
	}

}
