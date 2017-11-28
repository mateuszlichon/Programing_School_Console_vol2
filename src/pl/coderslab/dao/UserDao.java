package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.User;

public class UserDao {

	public static User[] loadAllUsers(Connection conn) throws SQLException {
		ArrayList<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User loadedUser = new User();
			loadedUser.setId(rs.getLong("id"));
			loadedUser.setUsername(rs.getString("username"));
			loadedUser.setPassword(rs.getString("password"));
			loadedUser.setEmail(rs.getString("email"));
			loadedUser.setUserGroupId(rs.getInt("user_group_id"));
			users.add(loadedUser);
		}
		User[] uArray = new User[users.size()];
		uArray = users.toArray(uArray);
		return uArray;
	}

	public static User[] loadAllByGruopId(Connection conn, int groupNumber) throws SQLException {
		ArrayList<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users JOIN user_group ON users.user_group_id = user_group.id WHERE user_group.id = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, groupNumber);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User loadedUser = new User();
			loadedUser.setId(rs.getLong("users.id"));
			loadedUser.setUsername(rs.getString("users.username"));
			loadedUser.setPassword(rs.getString("users.password"));
			loadedUser.setEmail(rs.getString("users.email"));
			loadedUser.setUserGroupId(rs.getInt("users.user_group_id"));
			users.add(loadedUser);
		}
		User[] uArray = new User[users.size()];
		uArray = users.toArray(uArray);
		return uArray;
	}
}
