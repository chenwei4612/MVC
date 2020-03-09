package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBC;

public class CartDao {
	// 自定义方法,把购物车的信息插入到数据库中
	public void insert(String uid, String isbn, int count) {
		// 获取数据库连接
		Connection con = JDBC.getConnection();
		// 编写sql语句
		String sql = "insert into t_cart(uid,book,count) values(?,?,?)";
		// 获取语句的预编译对象
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// 给预编译对象赋值
			ps.setString(1, uid);
			ps.setString(2, isbn);
			ps.setInt(3, count);
			// 执行sql语句
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 自定义方法,更新购物车的数量
	public void update(String uid, String isbn, int allCount) {
		// 获取数据库连接
		Connection con = JDBC.getConnection();
		// 编写sql语句
		String sql = "update t_cart set count=? where uid=? and book=?";
		// 获取语句的预编译对象
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// 给预编译对象赋值
			ps.setInt(1, allCount);
			ps.setString(2, uid);
			ps.setString(3, isbn);
			// 执行sql语句
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 自定义方法,查询购物车的数量
	public int selectByUidAndIsbn(String uid, String isbn) {
		// 定义一个int类型的变量
		int count = 0;
		// 获取数据库连接
		Connection con = JDBC.getConnection();
		// 编写sql语句
		String sql = "select * from t_cart where uid=? and book=?";
		// 获取语句的预编译对象
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// 给预编译对象赋值
			ps.setString(1, uid);
			ps.setString(2, isbn);
			// 执行sql语句
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		CartDao c = new CartDao();
//		c.insert("18610291580", "9787111564805", 10);
//		c.insert("18610291580", "9787111526285", 10);
		c.insert("18610291580", "9787115130228", 1111);
		int count = c.selectByUidAndIsbn("18610291580", "9787115130228");
		System.out.println(count+"-------");
	}
}
