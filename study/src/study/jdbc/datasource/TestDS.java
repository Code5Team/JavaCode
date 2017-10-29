package study.jdbc.datasource;

import java.sql.Connection;

import study.jdbc.utils.JDBCUtils;

public class TestDS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建连接池
		MyDataSource mds=new MyDataSource();
		Connection conn= mds.getConnection();
		JDBCUtils.printLn(conn);
		mds.addBack(conn);
		
	}

}
