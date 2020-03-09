package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;

public class UserRegistServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.��ȡҳ�����Ϣ
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Integer role = 0;

		// 2.��ҳ����Ϣ��װ��User����
		User user = new User();
		user.setPhone(phone);
		user.setEmail(email);
		user.setUname(uname);
		user.setUpwd(upwd);
		user.setRole(role);

		// 3.����dao���insert����,�����ݱ��浽���ݿ�
		UserDao dao = new UserDao();
		dao.insert(user);

		// 4.ҳ����ת(�ض���)
		response.sendRedirect("login.jsp");

	}

}
