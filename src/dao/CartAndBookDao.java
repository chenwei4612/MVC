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
	// �������,��ѯt_book �� t_cart
	public ArrayList<CartAndBook> selectByUid(String uid){
		// ����һ������
		ArrayList<CartAndBook> list = new ArrayList<CartAndBook>();
		// ����һ��Cart����
		Cart cart = new Cart();
		// ����һ��Book����
		Book book = new Book();
		// ����һ��cartAndBook����
		CartAndBook cab = new CartAndBook();
		
		Connection con = JDBC.getConnection();
		String sql = "select * from t_cart tc inner join t_book tb on tc.book=tb.isbn where tc.uid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				// 1.��װcart����
				cart = new Cart();
				cart.setBook(res.getString("isbn"));
				cart.setCount(res.getInt("count"));
				cart.setRid(res.getInt("rid"));
				cart.setUid(res.getString("uid"));
				// 2.��װbook����
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
				// 3.��װcab���������:��cart��book�Ž�ȥ
				cab = new CartAndBook();
				cab.setBook(book);
				cab.setCart(cart);
				// 4.��װ��������
				list.add(cab);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
