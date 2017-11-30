package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.db.DbUtil;

/**
 * Servlet implementation class SolutionsAdminEdit
 */
@WebServlet("/SolutionsAdminEdit")
public class SolutionsAdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolutionsAdminEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("solutionId");
		request.setAttribute("id", id);
		getServletContext().getRequestDispatcher("/solutionsAdminEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date created = Date.valueOf(request.getParameter("created"));
		Date updated = Date.valueOf(request.getParameter("updated"));
		String description = request.getParameter("description");
		int excerciseId = Integer.parseInt(request.getParameter("excerciseId"));
		long usersId = Long.parseLong(request.getParameter("usersId"));
		int solutionId = Integer.parseInt(request.getParameter("solutionId"));
		Connection conn;
		try {
			conn = DbUtil.getConn();
			SolutionDao.editSolution(conn, created, updated, description, excerciseId, usersId, solutionId);
			conn.close();
			getServletContext().getRequestDispatcher("/SolutionsAdmin").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
