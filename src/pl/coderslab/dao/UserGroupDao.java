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
}