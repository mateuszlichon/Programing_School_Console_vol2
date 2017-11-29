package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.model.UserGroup;

public class UserGroupDao {

	public static UserGroup[] loadAllGroups(Connection conn) throws SQLException {
		List<UserGroup> groups = new ArrayList<>();
		String sql = "SELECT * FROM user_group;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			UserGroup loadedGroup = new UserGroup();
			loadedGroup.setId(rs.getInt("id"));
			loadedGroup.setName(rs.getString("name"));
			groups.add(loadedGroup);
		}
		UserGroup[] uArray = new UserGroup[groups.size()];
		uArray = groups.toArray(uArray);
		return uArray;

	}
	
	public static void createGroup(Connection conn, String name) throws SQLException {
			String sql = "INSERT INTO user_group (name) VALUES (?);";
//			String gc[] = {"ID"};
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
//			ResultSet rs = ps.getGeneratedKeys();
/*			if (rs.next()) {
				this.id = rs.getInt(1);
			}*/
	}

	public static void editGroup(Connection conn, String name, int id) throws SQLException {
			String sql = "UPDATE user_group SET name = ? WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
		}
	
	public static void deleteGroup(Connection conn, int id) throws SQLException {
			String sql = "DELETE FROM user_group WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
	}
	
}