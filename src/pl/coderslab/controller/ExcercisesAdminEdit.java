package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExcerciseDao;
import pl.coderslab.db.DbUtil;

/**
 * Servlet implementation class ExcercisesAdminEdit
 */
@WebServlet("/ExcercisesAdminEdit")
public class ExcercisesAdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcercisesAdminEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("excerciseId");
		request.setAttribute("id", id);
		getServletContext().getRequestDispatcher("/excercisesAdminEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("excerciseId"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Connection conn;
		try {
			conn = DbUtil.getConn();
			ExcerciseDao.editExcercise(conn, title, description, id);
			conn.close();
			getServletContext().getRequestDispatcher("/ExcercisesAdmin").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
