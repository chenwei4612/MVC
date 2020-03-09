package dao;

//���ݷ���
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import utils.JDBC;

// ���ݷ��ʲ�,�ṩ�������ݿ���Ϣ��һϵ�з���
public class UserDao {
	/**
	 * ע��--�����ݿ��в�������,(��user�������ʽ)
	 */
	public void insert(User user) {
		// 1.��ȡ���ݿ�����
		Connection conn = JDBC.getConnection();
		// 2.��дsql���
		String sql = "insert into t_user(phone,uname,upwd,email,role) values (?,?,?,?,?)";
		// 3.��ȡԤ�������(С��)
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.��Ԥ�������ֵ
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getUname());
			ps.setString(3, user.getUpwd());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getRole());
			// 5.ִ�в������ݿ�
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * ��¼--��ѯ���ݿ�
	 */
	public User selectAllUser(String uname, String upwd, int role) {
		// 1.����һ���û�����
		User user = null;
		// 2.��ȡ���ݿ�����
		Connection conn = JDBC.getConnection();
		// 3.��дsql���
		String sql = "select * from t_user where uname=? and upwd=? and role=?";
		// 4.��ȡԤ�������
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// 5.��Ԥ�������ֵ
			ps.setString(1, uname);
			ps.setString(2, upwd);
			ps.setInt(3, role);
			// 6.ִ��sql���
			ResultSet rs = ps.executeQuery();
			// 7.���������,��װ���ݵ�user������
			if (rs.next()) {
				user = new User();
				user.setRole(rs.getInt("role"));
				user.setUname(rs.getString("uname"));
				user.setPhone(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	/**
	 * ajax�����첽У��ע���û���
	 */
	public User ajaxCheckUname(String uname,int role) {
		User user = null;
		// 1.��ȡ���ݿ�����
		Connection conn = JDBC.getConnection();
		// 2.��дsql���
		String sql = "select * from t_user where uname=? and role=?";
		// 3.��ȡԤ�������
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.Ϊ��丳ֵ
			ps.setString(1, uname);
			ps.setInt(2, role);
			
			// 5.ִ��sql���,��ȡ�����
			ResultSet res = ps.executeQuery();
			// 6.�ѽ����װ��user������
			if (res.next()) {
				user = new User();
				user.setEmail(res.getString("email"));
				user.setPhone(res.getString("phone"));
				user.setRole(res.getInt("role"));
				user.setUname(res.getString("uname"));
				user.setUpwd(res.getString("upwd"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.closeConnection(conn);
		}
		return user;
	}
	
	
}
