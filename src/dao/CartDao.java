package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBC;

public class CartDao {
	// �Զ��巽��,�ѹ��ﳵ����Ϣ���뵽���ݿ���
	public void insert(String uid, String isbn, int count) {
		// ��ȡ���ݿ�����
		Connection con = JDBC.getConnection();
		// ��дsql���
		String sql = "insert into t_cart(uid,book,count) values(?,?,?)";
		// ��ȡ����Ԥ�������
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ��Ԥ�������ֵ
			ps.setString(1, uid);
			ps.setString(2, isbn);
			ps.setInt(3, count);
			// ִ��sql���
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// �Զ��巽��,���¹��ﳵ������
	public void update(String uid, String isbn, int allCount) {
		// ��ȡ���ݿ�����
		Connection con = JDBC.getConnection();
		// ��дsql���
		String sql = "update t_cart set count=? where uid=? and book=?";
		// ��ȡ����Ԥ�������
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ��Ԥ�������ֵ
			ps.setInt(1, allCount);
			ps.setString(2, uid);
			ps.setString(3, isbn);
			// ִ��sql���
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// �Զ��巽��,��ѯ���ﳵ������
	public int selectByUidAndIsbn(String uid, String isbn) {
		// ����һ��int���͵ı���
		int count = 0;
		// ��ȡ���ݿ�����
		Connection con = JDBC.getConnection();
		// ��дsql���
		String sql = "select * from t_cart where uid=? and book=?";
		// ��ȡ����Ԥ�������
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ��Ԥ�������ֵ
			ps.setString(1, uid);
			ps.setString(2, isbn);
			// ִ��sql���
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
