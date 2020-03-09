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
		// ���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		// 1.��ȡҳ���е���Ϣ
		String isbn = request.getParameter("product");
		String count = request.getParameter("count");
		int iCount = Integer.parseInt(count);
		// ��session�л�ȡ�û���user����
		User user = (User) request.getSession().getAttribute("user");
		// 2.����dao��ķ���,���뵽���ﳵ�����ݿ���
		CartDao dao = new CartDao();
		// ���ж����ݿ����Ƿ��иñ���Ĺ�����Ϣ
		int oldCount = dao.selectByUidAndIsbn(user.getPhone(), isbn);
		if (oldCount == 0) {// ��ʾû�и�������Ϣ
			dao.insert(user.getPhone(), isbn, iCount);
		} else { // ��ʾ���ﳵ���иñ���
			int allCount = oldCount+iCount; 
			dao.update(user.getPhone(), isbn, allCount);
		}
		
		// 3.���ݽ��.������Ӧ��jspҳ��
		// 4.ajax��Ҫ��������������
		Writer out = response.getWriter();
		out.write("yes");
		out.close();
	}
}
