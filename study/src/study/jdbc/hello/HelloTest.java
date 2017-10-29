package study.jdbc.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import study.jdbc.utils.JDBCUtils;

/**
 * @author zhangyu 2017.10.26
 * 测试jdbc驱动
 */
public class HelloTest {

	/**
	 * jdbc测试
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void jdbcDrive() throws Exception{
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取链接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/day07", "root", "123456");
		//编写sql
		String sql="select * from category";
		//创建语句执行者
		PreparedStatement ps=conn.prepareStatement(sql);
		//设置参数
		//执行sql
		ResultSet rs=ps.executeQuery();
		//处理结果
		while(rs.next())
		{
			System.out.println(rs.getString("cid")+"="+rs.getString("cname"));
		}
		//释放资源
		rs.close();
		ps.close();
		conn.close();
	}
	
	@Test
	public void insertTest(){
		PreparedStatement ps=null;
		Connection conn=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="insert into  category values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "c008");
			ps.setString(2, "xddd");
			int c=ps.executeUpdate();
			if(c==1){
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	/**
	 * 更新
	 */
	@Test
	public void updateTest(){
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection conn=null;
		
		try {
			conn=JDBCUtils.getConnection();
			String sql="update category set cname=? where cid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "hbk");
			ps.setString(2, "c007");
			int re=ps.executeUpdate();
			if(re>0){
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(rs, ps, conn);
		}
	}
	
	@Test
	public void deleteTest(){
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection conn=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="delete from category  where cid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "c008");
			int re=ps.executeUpdate();
			if(re>0){
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(rs, ps, conn);
		}
	}
}
