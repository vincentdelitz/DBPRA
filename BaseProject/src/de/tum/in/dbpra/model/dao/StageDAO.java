package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.StageListBean;

public class StageDAO extends DAO{
	
	public void getPersonalStages(StageListBean stagelist, String firstname, String lastname) throws SQLException, ClassNotFoundException {
		
		//for testing reasons only simple test query
		String query = "SELECT * FROM stage;";	
		
		Connection con = getConnection();
		//con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			StageBean stage = new StageBean();
			stage.setStageID(rs.getInt("stagenr"));
			stage.setName(rs.getString("stagename"));
			stage.setSize(rs.getDouble("size"));
			stagelist.setChild(stage);
		} 
		
		//con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	

	
}
