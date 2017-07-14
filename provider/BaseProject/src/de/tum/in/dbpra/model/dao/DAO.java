/**
 * 
 */
package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import de.tum.in.dbpra.Config;
import de.tum.in.dbpra.Config.Database;

/**
 * @author Michael Schwarz
 * 
 */
public abstract class DAO {
	protected Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
        		"jdbc:postgresql://" 
        + Config.Database.HOST 
        + ":" + Config.Database.PORT
        + "/" + Config.Database.DB, 
        Config.Database.USER,
        Config.Database.PASS);
    }
}
