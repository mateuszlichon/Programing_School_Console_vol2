package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Solution;

public class SolutionDao {

	public static Solution loadSolutionById(Connection conn, int solutionId) throws SQLException {
		Solution solution = null;
		String sql = "SELECT * FROM solution WHERE id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, solutionId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			solution = new Solution(rs.getInt("id"), rs.getDate("created"), rs.getDate("updated"),
					rs.getString("description"), rs.getInt("excercise_id"), rs.getLong("users_id"));
		}
		return solution;
	}

	public static Solution[] loadAllSolution(Connection conn) throws SQLException {
		ArrayList<Solution> sols = new ArrayList<Solution>();
		String sql = "SELECT * FROM solution;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Solution sol = new Solution(rs.getInt("id"), rs.getDate("created"), rs.getDate("updated"),
					rs.getString("description"), rs.getInt("excercise_id"), rs.getLong("users_id"));
			sols.add(sol);
		}
		Solution[] sArray = new Solution[sols.size()];
		sArray = sols.toArray(sArray);
		return sArray;
	}

	public static void deleteSolution(Connection conn, int id) throws SQLException {
		String sql = "DELETE FROM solution WHERE id = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	public static void createSolution(Connection conn, Date created, Date updated, String description, int excerciseId,
			long usersId) throws SQLException {
		String sql = "INSERT INTO solution (created, updated, description, excercise_id, users_id) "
				+ "VALUES(?, ?, ?, ?, ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDate(1, created);
		ps.setDate(2, updated);
		ps.setString(3, description);
		ps.setInt(4, excerciseId);
		ps.setLong(5, usersId);
		ps.executeUpdate();
		ps.close();
	}

	public static void editSolution(Connection conn, Date created, Date updated, String description, int excerciseId,
			long usersId, int id) throws SQLException {
		String sql = "UPDATE solution SET created = ?, updated = ?, description = ?, excercise_id = ?, users_id =? "
				+ "WHERE id = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDate(1, created);
		ps.setDate(2, updated);
		ps.setString(3, description);
		ps.setInt(4, excerciseId);
		ps.setLong(5, usersId);
		ps.setInt(6, id);
		ps.executeUpdate();
		ps.close();
	}

}
