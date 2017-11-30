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
import pl.coderslab.model.Solution;

/**
 * Servlet implementation class SolutionsAdminAdd
 */
@WebServlet("/SolutionsAdminAdd")
public class SolutionsAdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolutionsAdminAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		try {
			conn = DbUtil.getConn();
			Solution[] solutions = SolutionDao.loadAllSolution(conn);
			request.setAttribute("solutions", solutions);
			conn.close();
			getServletContext().getRequestDispatcher("/solutionsAdmin.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		Connection conn;
		try {
			conn = DbUtil.getConn();
			SolutionDao.createSolution(conn, created, updated, description, excerciseId, usersId);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
