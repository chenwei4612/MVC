package servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import pojo.User;

public class AddBookToCartServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码格式
		request.setCharacterEncoding("utf-8");
		// 1.获取页面中的信息
		String isbn = request.getParameter("product");
		String count = request.getParameter("count");
		int iCount = Integer.parseInt(count);
		// 从session中获取用户的user对象
		User user = (User) request.getSession().getAttribute("user");
		// 2.调用dao层的方法,插入到购物车的数据库中
		CartDao dao = new CartDao();
		// 先判断数据库中是否有该本书的购物信息
		int oldCount = dao.selectByUidAndIsbn(user.getPhone(), isbn);
		if (oldCount == 0) {// 表示没有该数据信息
			dao.insert(user.getPhone(), isbn, iCount);
		} else { // 表示购物车中有该本书
			int allCount = oldCount+iCount; 
			dao.update(user.getPhone(), isbn, allCount);
		}
		
		// 3.根据结果.处理相应的jsp页面
		// 4.ajax需要进行流的输出结果
		Writer out = response.getWriter();
		out.write("yes");
		out.close();
	}
}
