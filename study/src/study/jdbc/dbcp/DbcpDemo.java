package study.jdbc.dbcp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import study.jdbc.utils.JDBCUtils;

public class DbcpDemo {
	@Test
	public void f1() throws Exception{
		//硬编码
		//创建连接池
		BasicDataSource bs = new BasicDataSource();
		//配置
		bs.setDriverClassName("com.mysql.jdbc.Driver");
		bs.setUrl("jdbc:mysql://localhost:3306/day07");
		bs.setUsername("root");
		bs.setPassword("123456");
		
		Connection conn= bs.getConnection();
		String sql="insert into  category values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "c009");
		ps.setString(2, "hu");
		int c=ps.executeUpdate();
		if(c==1){
			System.out.println("success");
		}
		else
		{
			System.out.println("fail");
		}
		JDBCUtils.closeResource(null, ps, conn);
	}
	
	@Test
	public void f2(){
		//配置文件
		Properties prop=new Properties();
		try {
			
			prop.load(new FileInputStream("src/dbcp.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//创建连接池
		try {
			DataSource bs = new BasicDataSourceFactory().createDataSource(prop);
			Connection conn= bs.getConnection();
			String sql="insert into  category values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "c010");
			ps.setString(2, "hus");
			int c=ps.executeUpdate();
			if(c==1){
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
			JDBCUtils.closeResource(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
