package com.xch.web;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;





import com.xch.dao.DaoI;
import com.xch.dao.DaoImpl;

public class MyListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("servlet context yet to be destroyed");
		
	}

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("servlet context created");
		DaoI dao = DaoImpl.getInstance();
		Set<String> cats = dao.getCategories();
		ServletContext ctx = event.getServletContext();
		ctx.setAttribute("catset", cats);
	}

}





