package servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;

public class CheckUnameServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取请求数据
		String uname = request.getParameter("uname");
		// 2.调用dao层
		UserDao dao = new UserDao();
		User user = dao.ajaxCheckUname(uname, 0);
		// 3.定义输出流,验证信息到前端页面显示
		Writer out = response.getWriter();
		// 4.判断是否存在用户
		if (user == null) { // 该用户名已被占用
			out.write("no");
		} else {
			out.write("yes");
		}
		// 5.关闭输出流
		out.close();
	}
}
