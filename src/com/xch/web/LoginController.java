package com.xch.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xch.dao.DaoI;
import com.xch.dao.DaoImpl;
import com.xch.vo.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession sees = request.getSession(false);
		if (sees != null) {
			sees.invalidate();
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("ProductMain.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String pass = request.getParameter("pwd");
		DaoI dao = DaoImpl.getInstance();
		User user = dao.login(uid, pass);
		HttpSession ses = request.getSession();
		ses.setAttribute("user", user);
		System.out.println(user == null);
		if (user == null) {
			System.out.println("asdasd");
			ses.setAttribute("msg", "You are not Autorized");
		}
		RequestDispatcher rd = request.getRequestDispatcher("ProductMain.jsp");
		rd.forward(request, response);
	}

}
