package study.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;


/**
 * @author zhangyu
 *jdbc帮助类
 */
public class JDBCUtils_ {
	/**
	 * 获取连接
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException
 {
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取链接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/day07", "root", "123456");
		return conn;
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
}
