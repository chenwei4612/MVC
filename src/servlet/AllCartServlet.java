package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartAndBookDao;
import pojo.CartAndBook;
import pojo.User;

public class AllCartServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  获取uid
		User user = (User) request.getSession().getAttribute("user");
		//调用dao层  
		CartAndBookDao dao = new CartAndBookDao();
		ArrayList<CartAndBook> list = dao.selectByUid(user.getPhone());
		//request
		request.setAttribute("cabs", list);
		//页面跳转
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
}
