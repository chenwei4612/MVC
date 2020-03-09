package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Book;
import utils.JDBC;

public class BookDao {
	/**
	 * 查询数据库中所有商品--商品首页
	 */
	public List<Book> selectAllBook(){
		List<Book> list = new ArrayList<Book>();
		// 1.获取数据库连接
		Connection con = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "select * from t_book";
		// 3.获取预编译对象
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			// 4.执行sql语句
			ResultSet res = ps.executeQuery();
			// 5.循环遍历结果集
			while (res.next()) {
				Book book = new Book();
				book.setAuthor(res.getString("author"));
				book.setEdition(res.getInt("edition"));
				book.setForm(res.getString("form"));
				book.setFormat(res.getString("format"));
				book.setIsbn(res.getString("isbn"));
				book.setPackaging(res.getString("packaging"));
				book.setPages(res.getInt("pages"));
				book.setPress(res.getString("press"));
				book.setPrice(res.getDouble("price"));
				book.setPublished(res.getDate("published"));
				book.setTitle(res.getString("title"));
				book.setWords(res.getInt("words"));
				list.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据主键查询某一本书的信息--详情页面
	 */
	
	public Book selectBookByIsbn(String isbn) {
		Book book = null;
		// 1.获取数据库的连接
		Connection conn = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "select * from t_book where isbn=?";
		// 3.获取预编译对象
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.给预编译对象赋值
			ps.setString(1, isbn);
			// 5.执行sql语句
			ResultSet res = ps.executeQuery();
			// 6.封装成Book对象
			if (res.next()) {
				book = new Book();
				book.setAuthor(res.getString("author"));
				book.setEdition(res.getInt("edition"));
				book.setForm(res.getString("form"));
				book.setFormat(res.getString("format"));
				book.setIsbn(res.getString("isbn"));
				book.setPackaging(res.getString("packaging"));
				book.setPages(res.getInt("pages"));
				book.setPress(res.getString("press"));
				book.setPrice(res.getDouble("price"));
				book.setPublished(res.getDate("published"));
				book.setTitle(res.getString("title"));
				book.setWords(res.getInt("words"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return book;
	}

}
