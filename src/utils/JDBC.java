package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//打开和关闭数据库连接
//参数： 数据库的 用户名 和 密码
//      数据库的访问路径
//      数据库的驱动
public class JDBC {
	//打开数据库连接
	public static Connection getConnection() {
		//1.定义一个连接
		Connection conn = null;
		//2.定义一个properties的对象
		Properties pro = new Properties();
		//3.读取配置文件的信息
		try {
			pro.load(JDBC.class.getClassLoader().getResourceAsStream("db.properties"));
			//4.获取配置文件的参数
			String driver = pro.getProperty("jdbc.driver");
			String url = pro.getProperty("jdbc.url");
			String username = pro.getProperty("jdbc.username");
			String password = pro.getProperty("jdbc.password");
			//5.加载驱动
			Class.forName(driver);
			//6.获取数据库的连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//关闭数据库连接
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		//获取连接
		Connection conn = JDBC.getConnection();
		//判断是否关闭
		boolean flag = conn.isClosed();
		System.out.println(flag);
	}
}
