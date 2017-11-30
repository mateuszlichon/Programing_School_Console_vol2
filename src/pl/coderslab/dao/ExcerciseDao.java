package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Excercise;

public class ExcerciseDao {

	public static void createExcercise(Connection conn, String title, String description) throws SQLException {
		String sql = "INSERT INTO excercise (title, description) " + "VALUES(?, ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, description);
		ps.executeUpdate();
		ps.close();
	}

	public static void editExcercise(Connection conn, String title, String description, int id) throws SQLException {
		String sql = "UPDATE excercise SET title = ?, description = ?" + "WHERE id = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, description);
		ps.setLong(3, id);
		ps.executeUpdate();
		ps.close();
	}

	public static Excercise loadExcerciseById(Connection conn, int id) throws SQLException {
		Excercise ex = new Excercise();
		String sql = "SELECT * FROM excercise WHERE id = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			ex.setId(rs.getInt("id"));
			ex.setTitle(rs.getString("title"));
			ex.setDescription(rs.getString("description"));
		}
		return ex;
	}

	public static Excercise[] loadAllExcercises(Connection conn) throws SQLException {
		ArrayList<Excercise> exs = new ArrayList<>();
		String sql = "SELECT * FROM excercise;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Excercise ex = new Excercise();
			ex.setId(rs.getInt("id"));
			ex.setTitle(rs.getString("title"));
			ex.setDescription(rs.getString("description"));
			exs.add(ex);
		}
		Excercise[] eArray = new Excercise[exs.size()];
		eArray = exs.toArray(eArray);
		return eArray;
	}

	public void deleteExcercise(Connection conn, int id) throws SQLException {
		String sql = "DELETE FROM excercise WHERE id = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.executeUpdate();
	}

}
