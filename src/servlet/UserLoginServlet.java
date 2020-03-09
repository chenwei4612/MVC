package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;

public class UserLoginServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取页面中的信息
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		int role = 0;
		// 2.调用dao层的select方法,从数据库中查找数据
		UserDao dao = new UserDao();
		User user = dao.selectAllUser(uname, upwd, role);
		// 3.页面跳转
		if (user != null) { // 从数据库中查找有此用户
			// 记录会话(该用户信息)
			request.getSession().setAttribute("user", user);  // ???参数的意义?
			request.getRequestDispatcher("AllBookServlet").forward(request, response);
		} else { // 数据库中没有该用户信息
			response.sendRedirect("login.jsp");
		}
	}
}
