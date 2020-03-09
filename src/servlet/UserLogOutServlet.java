package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogOutServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.移除session对象中的user对象
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		// 2.页面跳转
		response.sendRedirect("login.jsp");
	}
}
