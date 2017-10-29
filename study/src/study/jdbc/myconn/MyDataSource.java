package study.jdbc.myconn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.naming.LinkLoopException;

import study.jdbc.utils.JDBCUtils;


/**
 * @author zhangyu 
 *简易连接池
 */
public class MyDataSource {
	static LinkedList<Connection> pool=new LinkedList<Connection>();
	static{
		//创建三个连接池
		for (int i = 0; i < 3; i++) {
			try {
				Connection conn=JDBCUtils.getConnection();
				pool.addLast(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//连接池获取链接
	public static Connection getConnection(){
		if (pool.isEmpty()) {
			for (int i = 0; i < 3; i++) {
				try {
					Connection conn=JDBCUtils.getConnection();
					pool.addLast(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		JDBCUtils.printLn("从连接池获取一个连接");
		Connection conn=pool.removeFirst();
		//ConnectionWarp connectionWarp = new ConnectionWarp(conn);
		ConnectionWarp connectionWarp = new ConnectionWarp(conn,pool);
		return connectionWarp;
	}
	//归还链接
	public static void addBack(Connection conn){
		pool.addLast(conn);
		JDBCUtils.printLn("归还连接");
	}
}
