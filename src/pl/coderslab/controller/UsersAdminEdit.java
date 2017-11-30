package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.db.DbUtil;

/**
 * Servlet implementation class UsersAdminEdit
 */
@WebServlet("/UsersAdminEdit")
public class UsersAdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersAdminEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		getServletContext().getRequestDispatcher("/usersAdminEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		Connection conn;
		try {
			conn = DbUtil.getConn();
			UserDao.editUser(conn, name, email, password, groupId, id);
			conn.close();
			getServletContext().getRequestDispatcher("/UsersAdmin").forward(request, response);
		} catch (SQLException e) {
			getServletContext().getRequestDispatcher("/usersError.jsp").forward(request, response);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
