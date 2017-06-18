package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.LineitemBean;
import de.tum.in.dbpra.model.dao.CustomerDAO.CustomerNotFoundException;

public class LineitemDAO extends DAO{
	public void getLineItemByOrderkey(LineitemBean lineitem) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM lineitem WHERE orderkey = ?;";
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1, lineitem.getOrderkey());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			lineitem.setLinenumber(rs.getInt("linenumber"));
			lineitem.setPartkey(rs.getInt("partkey"));
			lineitem.setQuantity(rs.getInt("quantity"));
			lineitem.setExtendedprice(rs.getDouble("extendedprice"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
		
}
