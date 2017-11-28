package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import pl.coderslab.model.Solution;

public class SolutionDao {

	public static Solution loadSolutionById (Connection conn, int solutionId) throws SQLException {
		Solution solution = null;
		String sql = "SELECT * FROM solution WHERE id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, solutionId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			solution = new Solution(rs.getInt("id"), rs.getDate("created"), rs.getDate("updated"), rs.getString("description"), rs.getInt("excercise_id"), rs.getLong("users_id"));
		}
		return solution;
	}
	
}
