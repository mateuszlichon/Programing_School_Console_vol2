package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.db.DbUtil;

/**
 * Servlet implementation class UserGroupsAdminEdit
 */
@WebServlet("/UserGroupsAdminEdit")
public class UserGroupsAdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserGroupsAdminEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("groupId");
		request.setAttribute("id", id);
		getServletContext().getRequestDispatcher("/userGroupsAdminEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn;
		try {
			conn = DbUtil.getConn();
			UserGroupDao.editGroup(conn, name, id);
			conn.close();
			getServletContext().getRequestDispatcher("/UserGroupsAdmin").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
