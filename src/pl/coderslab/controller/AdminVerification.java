package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminVerification
 */
@WebServlet("/AdminVerification")
public class AdminVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminVerification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();
		if (s.getAttribute("password") == null) {
			getServletContext().getRequestDispatcher("/adminCheck.jsp").forward(request, response);
		} else {
			if (s.getAttribute("password").equals("coderslab")) {
				getServletContext().getRequestDispatcher("/adminWelcome.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/adminCheckFail.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();
		String verPassword = request.getParameter("verPassword");
		s.setAttribute("password", verPassword);
		doGet(request, response);
	}

}
