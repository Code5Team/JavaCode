package study.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Driver;


/**
 * @author zhangyu
 *jdbc帮助类
 */
public class JDBCUtils {
	static  String DC=null;
	static  String URL=null;
	static  String USER=null;
	static  String PD=null;
	
	static{
		 ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		 DC=bundle.getString("driverClass");
		 URL=bundle.getString("url");
		 USER=bundle.getString("user");
		 PD =bundle.getString("password");
	}

	static{
		try {
			// 注册驱动
			Class.forName(DC);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static Connection getConnection() throws SQLException
 {
		// 获取链接
		return DriverManager.getConnection(URL, USER, PD);
	}
	/**
	 * 释放资源
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	public static void closeResource(ResultSet rs,PreparedStatement ps,Connection conn)
	{
		closeResultSet(rs);
		closePreparedStatement(ps);
		closeConnection(conn);
	}
	public static void closeResultSet(ResultSet rs)
	{
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs=null;
	}
	
	public static void closePreparedStatement(PreparedStatement rs)
	{
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs=null;
	}
	public static void closeConnection(Connection rs)
	{
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs=null;
	}
	
	public static void printLn(String s){
		//快捷键是  syso 然后 alt+/
		System.out.println(s);
	}
	public static void printLn(int s){
		System.out.println(s);
	}
	public static void printLn(Object s){
		System.out.println(s);
	}
}
