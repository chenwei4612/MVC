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
		// 1.��ȡҳ�����Ϣ(��ȡһ�����isbn)
		String isbn = request.getParameter("isbn");
		// 2.����dao��Ĳ�ѯ���������ݿ����ҵ����������
		BookDao bd = new BookDao();
		Book book = bd.selectBookByIsbn(isbn);
		// 3.��װ��request������
		request.setAttribute("book", book);
		// 4.ҳ����ת
		request.getRequestDispatcher("detail.jsp").forward(request, response);
		
	}
}
