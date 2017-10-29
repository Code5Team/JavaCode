package study.jdbc.myconn;

import java.sql.Connection;
import java.sql.SQLException;

import study.jdbc.utils.JDBCUtils;

public class TestDS {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//创建连接池
		MyDataSource mds=new MyDataSource();
		Connection conn= mds.getConnection();
		conn.close();
		
	}

}
