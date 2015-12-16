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
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		HttpSession sess=request.getSession(false);
		if(sess.getAttribute("login")!=null){
		if(path.equals("/Viewall")){
			DaoI dao=DaoImpl.getInstance();
			List<Product> prods=dao.getProducts();
			request.setAttribute("prodlist", prods);
			String view=response.encodeURL("WEB-INF/ProductView.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/ProductView.jsp");
			rd.forward(request,response);
		}
		else if(path.equals("/viewid")){
			int pid=Integer.parseInt(request.getParameter("txtid"));
			DaoI dao=DaoImpl.getInstance();
			Product prod=dao.getProducts(pid);
			request.setAttribute("aprod", prod);
			String view=response.encodeURL("AProduct.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("AProduct.jsp");
			rd.forward(request,response);
		}
		else if(path.equals("/viewcat")){
			String cat=request.getParameter("txtcat");
			DaoI dao=DaoImpl.getInstance();
			List<Product> prods=dao.getProducts(cat);
			request.setAttribute("prodlist", prods);
			String view=response.encodeURL("WEB-INF/ProductView.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/ProductView.jsp");
			rd.forward(request,response);
		}
		else if(path.equals("/add")){
			int pid=Integer.parseInt(request.getParameter("txtid"));
			String cat=request.getParameter("txtcat");
			String name=request.getParameter("txtname");
			String img=request.getParameter("txtimg");
			Double price=Double.parseDouble("txtprice");
			DaoI dao=DaoImpl.getInstance();
			Product prod=new Product();
			prod.setCat(cat);
			prod.setPid(pid);
			prod.setPimg(img);
			prod.setPrice(price);
			prod.setPname(name);
			int rows=dao.addProduct(prod);
			
			String view=response.encodeURL("ProductMain.jsp");
			System.out.println(rows+" rows affected");
			RequestDispatcher rd=request.getRequestDispatcher(view);
			rd.forward(request,response);
			
		}
		}
		else{
			String view="Login.jsp";
			request.setAttribute("msg", "You are not an authenticated user");
			RequestDispatcher rd=request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	}

}
