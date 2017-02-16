package com.example.servlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	static Log log = LogFactory.getLog(LoginServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			log.info("doget");
		
			String err = req.getParameter("err");
			if (err != null)
				req.setAttribute("errmsg", "id,pass확인");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/loginform.jsp");
			dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("dopost");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		log.info("id"+id);
		log.info("pw"+pw);
		
		if("hong".equals(id) && "1234".equals(pw)){
			resp.sendRedirect("/index.jsp");
		} else {
			resp.sendRedirect("/login?err");
		}
	}
	

	
	
}
