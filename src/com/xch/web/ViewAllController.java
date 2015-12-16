package com.xch.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xch.dao.DaoI;
import com.xch.dao.DaoImpl;
import com.xch.vo.Product;

/**
 * Servlet implementation class ViewAllController
 */
public class ViewAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		DaoI dao = DaoImpl.getInstance();
		RequestDispatcher rd;
		String view;
		String path = request.getServletPath();
		List<Product> list = null;
		if (path.equals("/viewall")) {
			if (ses.getAttribute("prodList") == null) {
				list = dao.getProducts();
				ses.setAttribute("prodList1", list);
			} else {
				list = (List<Product>) ses.getAttribute("prodList1");
			}
			int totpages = list.size();
			int page = 1;
			if ("null".equalsIgnoreCase(request.getParameter("pg"))) {
				page = 1;
			} else {
				page = Integer.parseInt(request.getParameter("pg"));
			}
			int end = page * 3;
			int start = end - 3;
			ses.setAttribute("currpage", page);
			if (end >= totpages) {
				end = totpages;
			}
			List<Product> sublist = list.subList(start, end);
			ses.setAttribute("prodList", sublist);
			int link = (int) Math.ceil(totpages / 3.0);
			request.setAttribute("totpages", totpages);
			request.setAttribute("link", link);
		}else if(path.equals("/next")){
			list = (List<Product>) ses.getAttribute("prodList1");
			int currpage= (Integer) ses.getAttribute("currpage");
			int end = currpage * 3;
			int start = end - 3;
			List<Product> sublist = list.subList(start, end);
			int totpages = list.size();
			if (end >= totpages) {
				end = totpages;
			}
			ses.removeAttribute("prodList");
			ses.setAttribute("prodList", sublist);
			int link = (int) Math.ceil(totpages / 3.0);
			request.setAttribute("totpages", totpages);
			request.setAttribute("link", link);
			
		}
		rd = request.getRequestDispatcher("WEB-INF/ProductView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
