package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import pojo.Book;

public class AllBookServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.调用dao层的查询方法,从数据库中查找到所有书本信息
		BookDao dao = new BookDao();
		List<Book> list = dao.selectAllBook();
		// 2.封装到request对象中
		request.setAttribute("books", list);
		// 3.页面跳转
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
