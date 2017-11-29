package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.SolutionDto;
import pl.coderslab.model.User;

public class SolutionDtoDao {

	
	public static SolutionDto[] loadSolutionsWithUsers(Connection conn) throws SQLException {
		ArrayList<SolutionDto> solutionsDto = new ArrayList<>();
		String sql = "SELECT excercise.title, users.username, solution.created, solution.id FROM excercise JOIN solution ON excercise.id = solution.excercise_id JOIN users ON solution.users_id = users.id ORDER BY solution.created DESC;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			SolutionDto loaded = new SolutionDto(rs.getString("excercise.title"), rs.getString("users.username"), rs.getDate("solution.created"), rs.getInt("solution.id"));
/*			loaded.setExcerciseTitle(rs.getString("excercise.title"));
			loaded.setUserName(rs.getString("users.username"));
			loaded.setCreationDate(rs.getDate("solution.created"));
			loaded.setSolutionId(rs.getInt("solution.id"));*/
			solutionsDto.add(loaded);
		}
		SolutionDto[] uArray = new SolutionDto[solutionsDto.size()];
		uArray = solutionsDto.toArray(uArray);
		return uArray;
	}
	
}
