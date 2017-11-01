package study.jdbc.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import study.jdbc.utils.JDBCUtils;

public class C3p0Test {
	//也有硬编码格式，类似dbcp,不常用
	@Test
	public void insertTest() throws SQLException {
		ComboPooledDataSource bs=new ComboPooledDataSource();
		Connection conn= bs.getConnection();
		String sql="insert into  category values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "c012");
		ps.setString(2, "hr");
		int c=ps.executeUpdate();
		if(c==1){
			System.out.println("success");
		}
		else
		{
			System.out.println("fail");
		}
	}
}
