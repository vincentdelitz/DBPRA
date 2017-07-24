package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.tum.in.dbpra.model.bean.VisitorBean;
import de.tum.in.dbpra.model.dao.OfferProductDAO.OffersNotFoundException;

public class VisitorDAO extends DAO {
	
	public ArrayList<VisitorBean> getVisitors(String firstname, String lastname)
			throws ClassNotFoundException, SQLException, VisitorsNotFoundException {
		String query = 
				"SELECT person.salutation, person.firstname, person.lastname, ticketid, visitorid, category, buytime, finalprice, balance FROM visitor join person on(visitor.visitorid=person.personid)"+ 
		" where lower(firstname) like lower(?) and lower(lastname) like lower(?)";

		//execute query
		Connection con = getConnection();
		con.setAutoCommit(false);
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, firstname);
		pstmt.setString(2, lastname);
		ResultSet rs = pstmt.executeQuery();

		ArrayList<VisitorBean> visitors = new ArrayList<VisitorBean>();

		int count = 0;
		
		//fill offerBean
		while (rs.next()) {
			VisitorBean vb = new VisitorBean();
			
			vb.setFirstname(rs.getString("firstname"));
			vb.setLastname(rs.getString("lastname"));
			vb.setSalutation(rs.getString("salutation"));
			vb.setBalance(rs.getDouble("balance"));
			vb.setFinalprice(rs.getDouble("finalprice"));
			vb.setCategory(rs.getString("category"));
			vb.setBuytime(rs.getDate("buytime"));
			vb.setTicketID(rs.getInt("ticketid"));
			vb.setVisitorID(rs.getInt("visitorid"));
			visitors.add(vb);
			count++;
		}
		//if count=0, there is no result in the result set.
		//So we consider it as an exception and rollback the transaction
		if (count == 0) {
			rs.close();
			pstmt.close();
			con.rollback();
			con.close();
			throw new VisitorsNotFoundException("There is no visitor "+firstname+ " " +lastname+"!");

		} 
		//otherwise commit it
		else {
			
			rs.close();
			pstmt.close();
			con.commit();
			con.close();
		}
		return visitors;
	}
	
	public static class VisitorsNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		VisitorsNotFoundException(String message) {
			super(message);
		}
	}
}
