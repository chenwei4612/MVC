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
		// 1.��ȡ��������
		String uname = request.getParameter("uname");
		// 2.����dao��
		UserDao dao = new UserDao();
		User user = dao.ajaxCheckUname(uname, 0);
		// 3.���������,��֤��Ϣ��ǰ��ҳ����ʾ
		Writer out = response.getWriter();
		// 4.�ж��Ƿ�����û�
		if (user == null) { // ���û����ѱ�ռ��
			out.write("no");
		} else {
			out.write("yes");
		}
		// 5.�ر������
		out.close();
	}
}
