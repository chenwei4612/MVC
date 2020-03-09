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
		// 1.����dao��Ĳ�ѯ����,�����ݿ��в��ҵ������鱾��Ϣ
		BookDao dao = new BookDao();
		List<Book> list = dao.selectAllBook();
		// 2.��װ��request������
		request.setAttribute("books", list);
		// 3.ҳ����ת
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
