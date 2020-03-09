package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import pojo.Book;

public class DetailBookServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取页面的信息(获取一本书的isbn)
		String isbn = request.getParameter("isbn");
		// 2.调用dao层的查询方法从数据库中找到被点击的书
		BookDao bd = new BookDao();
		Book book = bd.selectBookByIsbn(isbn);
		// 3.封装到request对象中
		request.setAttribute("book", book);
		// 4.页面跳转
		request.getRequestDispatcher("detail.jsp").forward(request, response);
		
	}
}
