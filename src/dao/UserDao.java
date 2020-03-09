package dao;

//数据访问
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import utils.JDBC;

// 数据访问层,提供访问数据库信息的一系列方法
public class UserDao {
	/**
	 * 注册--向数据库中插入数据,(以user对象的形式)
	 */
	public void insert(User user) {
		// 1.获取数据库连接
		Connection conn = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "insert into t_user(phone,uname,upwd,email,role) values (?,?,?,?,?)";
		// 3.获取预编译对象(小车)
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.给预编译对象赋值
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getUname());
			ps.setString(3, user.getUpwd());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getRole());
			// 5.执行插入数据库
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * 登录--查询数据库
	 */
	public User selectAllUser(String uname, String upwd, int role) {
		// 1.定义一个用户对象
		User user = null;
		// 2.获取数据库连接
		Connection conn = JDBC.getConnection();
		// 3.编写sql语句
		String sql = "select * from t_user where uname=? and upwd=? and role=?";
		// 4.获取预编译对象
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// 5.给预编译对象赋值
			ps.setString(1, uname);
			ps.setString(2, upwd);
			ps.setInt(3, role);
			// 6.执行sql语句
			ResultSet rs = ps.executeQuery();
			// 7.遍历结果集,封装数据到user对象中
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
	 * ajax技术异步校验注册用户名
	 */
	public User ajaxCheckUname(String uname,int role) {
		User user = null;
		// 1.获取数据库连接
		Connection conn = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "select * from t_user where uname=? and role=?";
		// 3.获取预编译对象
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.为语句赋值
			ps.setString(1, uname);
			ps.setInt(2, role);
			
			// 5.执行sql语句,获取结果集
			ResultSet res = ps.executeQuery();
			// 6.把结果封装到user对象中
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
