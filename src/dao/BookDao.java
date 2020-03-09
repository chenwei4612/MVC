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
	 * ��ѯ���ݿ���������Ʒ--��Ʒ��ҳ
	 */
	public List<Book> selectAllBook(){
		List<Book> list = new ArrayList<Book>();
		// 1.��ȡ���ݿ�����
		Connection con = JDBC.getConnection();
		// 2.��дsql���
		String sql = "select * from t_book";
		// 3.��ȡԤ�������
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			// 4.ִ��sql���
			ResultSet res = ps.executeQuery();
			// 5.ѭ�����������
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
	 * ����������ѯĳһ�������Ϣ--����ҳ��
	 */
	
	public Book selectBookByIsbn(String isbn) {
		Book book = null;
		// 1.��ȡ���ݿ������
		Connection conn = JDBC.getConnection();
		// 2.��дsql���
		String sql = "select * from t_book where isbn=?";
		// 3.��ȡԤ�������
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.��Ԥ�������ֵ
			ps.setString(1, isbn);
			// 5.ִ��sql���
			ResultSet res = ps.executeQuery();
			// 6.��װ��Book����
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
