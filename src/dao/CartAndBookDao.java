package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Book;
import pojo.Cart;
import pojo.CartAndBook;
import utils.JDBC;

public class CartAndBookDao {
	// 多表联查,查询t_book 和 t_cart
	public ArrayList<CartAndBook> selectByUid(String uid){
		// 定义一个集合
		ArrayList<CartAndBook> list = new ArrayList<CartAndBook>();
		// 定义一个Cart对象
		Cart cart = new Cart();
		// 定义一个Book对象
		Book book = new Book();
		// 定义一个cartAndBook对象
		CartAndBook cab = new CartAndBook();
		
		Connection con = JDBC.getConnection();
		String sql = "select * from t_cart tc inner join t_book tb on tc.book=tb.isbn where tc.uid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				// 1.封装cart对象
				cart = new Cart();
				cart.setBook(res.getString("isbn"));
				cart.setCount(res.getInt("count"));
				cart.setRid(res.getInt("rid"));
				cart.setUid(res.getString("uid"));
				// 2.封装book对象
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
				// 3.封装cab对象的数据:把cart和book放进去
				cab = new CartAndBook();
				cab.setBook(book);
				cab.setCart(cart);
				// 4.封装到集合中
				list.add(cab);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
