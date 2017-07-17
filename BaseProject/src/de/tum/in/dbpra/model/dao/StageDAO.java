package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.StageListBean;

public class StageDAO extends DAO {

	public void getPersonalStages(StageListBean stagelist, String firstname,
			String lastname) throws SQLException, ClassNotFoundException {

		
		String query = "SELECT DISTINCT stage.stageNr, stage.stagename, stage.size"
				+ " FROM stage WHERE stage.stageNr IN (SELECT stage.stageNr FROM stage INNER JOIN lineup"
				+ " ON stage.stageNr = lineup.stageNr INNER JOIN band ON lineup.bandID = band.bandID"
				+ " INNER JOIN timetable ON timetable.bandID = band.bandID INNER JOIN visitor"
				+ " ON timetable.visitorID = visitor.visitorID INNER JOIN Person ON visitor.visitorID = person.personID"
				+ " WHERE person.firstname = ? AND person.lastname = ?);";

		Connection con = getConnection();
		// con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, firstname);
		pstmt.setString(2, lastname);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			StageBean stage = new StageBean();
			stage.setStageID(rs.getInt("stagenr"));
			stage.setName(rs.getString("stagename"));
			stage.setSize(rs.getDouble("size"));
			stagelist.setChild(stage);
		}

		// con.commit();
		rs.close();
		pstmt.close();
		con.close();

	}

}
