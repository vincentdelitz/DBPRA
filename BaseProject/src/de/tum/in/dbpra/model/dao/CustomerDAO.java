package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.CustomerBean;

public class CustomerDAO extends DAO{
	public void getCustomerById(CustomerBean customer) throws CustomerNotFoundException, SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM customer WHERE custkey = ?;";
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1, customer.getCustkey());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			customer.setName(rs.getString("name"));
			customer.setAddress(rs.getString("address"));
			customer.setAcctbal(rs.getDouble("acctbal"));
		} else {
			throw new CustomerNotFoundException("There is no Customer with id " + customer.getCustkey() + "!");
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	public static class CustomerNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		CustomerNotFoundException(String message){
			super(message);
		}
	}
}
