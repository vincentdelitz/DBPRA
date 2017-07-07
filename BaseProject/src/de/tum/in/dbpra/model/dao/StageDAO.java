package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.tum.in.dbpra.model.bean.OrderBean;
import de.tum.in.dbpra.model.bean.OrderListBean;
import de.tum.in.dbpra.model.bean.PartBean;
import de.tum.in.dbpra.model.bean.PartListBean;
import de.tum.in.dbpra.model.bean.StageBean;

public class StageDAO extends DAO{
	
	public void getPersonalStages(ArrayList<StageBean> stagelist, String firstname, String lastname) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM stage;";	
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			StageBean stage = new StageBean();
			stage.setStageID(rs.getInt("stageID"));
			stage.setName(rs.getString("name"));
			stage.setSize(rs.getDouble("size"));
			stagelist.add(stage);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	

	
}
