package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Migrate {
	Connection conn = null;	// 创建一个数据库连接
	PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
	ResultSet res  = null;	// 创建一个结果集对象
	
	Connection ms_conn = null;	// 创建一个数据库连接
	PreparedStatement ms_pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
	ResultSet ms_res  = null;	// 创建一个结果集对象
	
	public static void main(String[] args)
	{
		//太危险了，一用就导入20000条数据不说还容易破坏数据，赶紧注释掉 -_-!
//		Migrate mg = new Migrate();
//		mg.migrate();
	}
	
	public void migrate()
	{
		this.getConnected();
		this.getmysql_Connected();
		
		int counts = 0;
		String selectsql = "select 姓名,身份证号,借书证号,性别,民族,单位,单位代码,照片 from 读者库";
		String insertsql = "insert into student(姓名,身份证号,一卡通图书证号,性别,民族,部门名称,部门代码,学生照片) values(?,?,?,?,?,?,?,?)";
		try{
			pre = conn.prepareStatement(selectsql);
			res = pre.executeQuery();
			while(res.next())
			{
				ms_pre = ms_conn.prepareStatement(insertsql);
				
				ms_pre.setString(1, res.getString(1));
				ms_pre.setString(2, res.getString(2));
				ms_pre.setString(3, res.getString(3));
				ms_pre.setString(4, res.getString(4));
				ms_pre.setString(5, res.getString(5));
				ms_pre.setString(6, res.getString(6));
				ms_pre.setString(7, res.getString(7));
				ms_pre.setBlob(8, res.getBlob("照片"));
				
				ms_pre.executeUpdate();
				counts++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
	    {
			this.closeConnection();
			this.closemysql_Connection();
	    }
		System.out.println(counts);
	}
	
	/*
	 * 新建连接
	 */
	public void getmysql_Connected()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接Mysql数据库！");
	        String url = "jdbc:mysql:" + "//127.0.0.1:3306/hit";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "root";// 用户名,系统默认的账户名
	        String password = "121386";// 你安装时选设置的密码
	        ms_conn = DriverManager.getConnection(url, user, password);// 获取连接
	        System.out.println("Mysql连接成功！");
		} 
		catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	
	/*
	 * 关闭连接
	 */
	public void closemysql_Connection()
	{
		try
        {
            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
            // 注意关闭的顺序，最后使用的最先关闭
            if (ms_res != null)
            	ms_res.close();
            if (ms_pre != null)
            	ms_pre.close();
            if (ms_conn != null)
            	ms_conn.close();
            System.out.println("Mysql数据库连接已关闭！");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	/*
	 * 新建连接
	 */
	public void getConnected()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");
	        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "noka";// 用户名,系统默认的账户名
	        String password = "121386";// 你安装时选设置的密码
	        conn = DriverManager.getConnection(url, user, password);// 获取连接
	        System.out.println("连接成功！");
		} 
		catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	
	/*
	 * 关闭连接
	 */
	public void closeConnection()
	{
		try
        {
            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
            // 注意关闭的顺序，最后使用的最先关闭
            if (res != null)
                res.close();
            if (pre != null)
                pre.close();
            if (conn != null)
                conn.close();
            System.out.println("数据库连接已关闭！");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
}
