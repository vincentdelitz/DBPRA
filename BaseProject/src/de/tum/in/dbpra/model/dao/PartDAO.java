package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.OrderBean;
import de.tum.in.dbpra.model.bean.OrderListBean;
import de.tum.in.dbpra.model.bean.PartBean;
import de.tum.in.dbpra.model.bean.PartListBean;

public class PartDAO extends DAO{
	
	public void getParts(PartListBean partlist) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM part ORDER BY name ASC";	
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			PartBean part = new PartBean();
			part.setPartkey(rs.getInt("partkey"));
			part.setName(rs.getString("name"));
			part.setSize(rs.getInt("size"));
			part.setContainer(rs.getInt("container"));
			part.setRetailprice(rs.getInt("retailprice"));
			partlist.setChild(part);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
}
