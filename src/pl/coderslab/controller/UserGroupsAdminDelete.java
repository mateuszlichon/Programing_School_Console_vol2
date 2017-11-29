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
import pl.coderslab.model.UserGroup;

/**
 * Servlet implementation class UserGroupsAdminDelete
 */
@WebServlet("/UserGroupsAdminDelete")
public class UserGroupsAdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserGroupsAdminDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		Connection conn;
		try {
			conn = DbUtil.getConn();
			UserGroupDao.deleteGroup(conn, groupId);
			UserGroup[] groups = UserGroupDao.loadAllGroups(conn);
			conn.close();
			request.setAttribute("groups", groups);
			getServletContext().getRequestDispatcher("/userGroupsAdmin.jsp").forward(request, response);
		} catch (SQLException e) {
			getServletContext().getRequestDispatcher("/usedGroupError.jsp").forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
