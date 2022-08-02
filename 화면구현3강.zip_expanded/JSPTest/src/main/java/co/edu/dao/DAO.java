package co.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	/*
	 * Field
	 */
	// field for DB connect
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	// field for DB configuration
	private String cDriver = "oracle.jdbc.driver.OracleDriver";
	private String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String cId = "hr";
	private String cPwd = "hr";


	/*
	 * Method
	 */
	// DB connect
	public void connect() {
		
		try {
			Class.forName(cDriver);
			conn = DriverManager.getConnection(cUrl, cId, cPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// DB disconnect
	public void disconnect() {

		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}