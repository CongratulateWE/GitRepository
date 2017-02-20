package DAO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.Reader;
import Entity.Student;

public class MysqlDAO {
	
	public static void main(String[] arg)
	{
		MysqlDAO md = new MysqlDAO();
		try {
			md.getPhoto("7");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		md.getConnected();
//		md.insertRecord(new Student());
//		ArrayList<Student> sl = md.selectRecordById("1014");
//		int c = md.deleteRecordById("28000");
//		System.out.println(c);
		
		//测试修改，测试成功
//		int counts = md.updateRecord("16137036", "16137044");System.out.println(counts);
		
		//测试分页
//		md.selectRecordsByPage(1000, 10);
		
		//测试插入，以student作为参数
//		Student st = new Student();
//		st.setName("阿飞2");
//		st.setStartdate("2016-12-13");
//		md.insertRecord(st);
//		"C:\\Users\\nokan\\Desktop\\1.png"
		
		
		//测试更灵活的修改	SUCCESS
//		System.out.println(md.updateRecord("身份证号", "14272719950830", "ID", "28000"));
	}

	/*
	 * 页搜索
	 */
	public ArrayList<Student> selectRecordsByPage(int page, int pageSize)
	{
		getConnected();
		System.out.println("mysqlDAO: selectReadersByPage:p=" + page +" s="+ pageSize);
		ArrayList<Student> StudentList = new ArrayList<Student>();
		try{
			String sql = "select ID,学号,姓名,身份证号,一卡通卡号,一卡通图书证号,性别,民族,部门名称,部门代码,公寓ID,公寓名称,房间ID,房间名称,楼层,床位号,入学时间,人员类别 from student "
					+ "where ID limit " + (page-1) * pageSize + "," + pageSize;
			
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			
			while (res.next())
	        {
				Student student = new Student(res.getString(1),res.getString(2),res.getString(3),res.getString(4),	res.getString(5),
	        			res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10), res.getString(11), res.getString(12), 
	        			res.getString(13), res.getString(14), res.getString(15), res.getString(16), res.getString(17), res.getString(18));
	        	System.out.println("mysqlDAO:" + student.toString());
	        	StudentList.add(student);
	        }
			
		}catch (Exception e)
	    {
	        e.printStackTrace();
	    }
		finally
	    {
	        this.closeConnection();
	    }
		
		return StudentList;
	} 
	
	/*
	 * 通过ID进行删除
	 */
	public int deleteRecordById(String id)
	{
		int counts = -1;
		getConnected();
		try{
			String sql = "delete from student where ID = ?";
			
			pre = conn.prepareStatement(sql);
			pre.setString(1, id);
			counts = pre.executeUpdate();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
	    {
	        this.closeConnection();
	    }
		return counts;
	}
	
	public ArrayList<Student> selectRecordByDiyid(String column,String id)
	{
		getConnected();
		System.out.println("DAO selectReadersById:" + id);
		ArrayList<Student> ReaderList = new ArrayList<Student>();
		try{
			String sql = "select ID,学号,姓名,身份证号,一卡通卡号,一卡通图书证号,性别,民族,部门名称,部门代码,公寓ID,公寓名称,房间ID,房间名称,楼层,床位号,入学时间,人员类别 "
					+ "from student where " + column + " = ?";// 预编译语句，“？”代表参数
			
	        pre = conn.prepareStatement(sql);// 实例化预编译语句
	        pre.setString(1, id);			// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        res = pre.executeQuery();		// 执行查询，注意括号中不需要再加参数	
	        
	        while(res.next())
	        {
	        	Student student = new Student(res.getString(1),res.getString(2),res.getString(3),res.getString(4),	res.getString(5),
	        			res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10), res.getString(11), res.getString(12), 
	        			res.getString(13), res.getString(14), res.getString(15), res.getString(16), res.getString(17), res.getString(18));
	        	System.out.println(student.toString());
	        	ReaderList.add(student);
	        }
		} catch (Exception e)
	    {
	        e.printStackTrace();
	    }
		finally
	    {
	        this.closeConnection();
	    }
		return ReaderList;
	}
	
	/*
	 * 通过id来查找用户
	 * 应该是没用到把
	 */	
	public ArrayList<Student> selectRecordById(String id)
	{
		getConnected();
		System.out.println("selectReadersById:" + id);
		ArrayList<Student> ReaderList = new ArrayList<Student>();
		try{
			String sql = "select ID,student.ID,学号,姓名,身份证号,一卡通卡号,一卡通图书证号,性别,民族,部门名称,部门代码,公寓ID,公寓名称,房间ID,房间名称,楼层,床位号,入学时间,人员类别 "
					+ "from student where ID = ?";// 预编译语句，“？”代表参数
	        pre = conn.prepareStatement(sql);// 实例化预编译语句
	        pre.setString(1, id);			// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        res = pre.executeQuery();		// 执行查询，注意括号中不需要再加参数	
	        
	        while(res.next())
	        {
	        	Student student = new Student(res.getString(1),res.getString(2),res.getString(3),res.getString(4),	res.getString(5),
	        			res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10), res.getString(11), res.getString(12), 
	        			res.getString(13), res.getString(14), res.getString(15), res.getString(16), res.getString(17), res.getString(18));
	        	System.out.println(student.toString());
	        	ReaderList.add(student);
	        }
		} catch (Exception e)
	    {
	        e.printStackTrace();
	    }
		finally
	    {
	        this.closeConnection();
	    }
		return ReaderList;
	}
	
	
	/*
	 * 通过ID修改图书证号
	 */
	public int updateRecord(String lib_id, String new_lib)
	{
		int counts = -1;
		this.getConnected();
		String sql = "update student set 一卡通图书证号 = ? where ID = ?";
		System.out.println(sql + "lib_id:" + lib_id + ",new_lib:" + new_lib);
		try{
			pre = conn.prepareStatement(sql);
			pre.setString(1, new_lib);
			pre.setString(2, lib_id);
			counts = pre.executeUpdate();
			System.out.println("counts:" + counts);
		}
		catch (Exception e)
	    {
	        e.printStackTrace();
	    }
		finally
	    {
	        this.closeConnection();
	    }
		
		return counts;
	}
	
	/**
	 * 需要按照sql的顺序依次输入 列名，值，索引列，索引值
	 * @param column
	 * @param value
	 * @param indexcolumn
	 * @param indexvalue
	 * @return
	 */
	public int updateRecord(String column, String value, String indexcolumn, String indexvalue)
	{
		int counts = -1;
		this.getConnected();
		String sql = "update student set " + column + " = ? where " + indexcolumn + " = ?";
		System.out.println("MysqlDAO: " + sql);
		try{
			pre = conn.prepareStatement(sql);
			pre.setString(1, value);
			pre.setString(2, indexvalue);
			counts = pre.executeUpdate();
			System.out.println("counts:" + counts);
		}
		catch (Exception e)
	    {
	        e.printStackTrace();
	    }
		finally
	    {
	        this.closeConnection();
	    }
		
		return counts;
	}
	
	
	/*
	 * 传入学生实体，插入数据库
	 * 照片项可以为空，如果为空插入null
	 */
	public int insertRecord(Student st)
	{
		int counts = -1;
		this.getConnected();
		try{
			String sql = "insert into student(学号,姓名,身份证号,一卡通卡号,一卡通图书证号,性别,民族,部门名称,部门代码,公寓ID,"
					+ "公寓名称,房间ID,房间名称,楼层,床位号,入学时间,人员类别,学生照片) values(?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, st.getStudent_id());
			pre.setString(2, st.getName());
			pre.setString(3, st.getId_card());
			pre.setString(4, st.getCampus_card());
			pre.setString(5, st.getCampus_card_lib());
			pre.setString(6, st.getGender());
			pre.setString(7, st.getNationality());
			pre.setString(8, st.getDivision());
			pre.setString(9, st.getDiv_code());
			pre.setString(10, st.getDormitory_id());
			pre.setString(11, st.getDormitory());
			pre.setString(12, st.getRoom_id());
			pre.setString(13, st.getRoom());
			pre.setString(14, st.getFloor());
			pre.setString(15, st.getBed());
			pre.setString(16, st.getStartdate());
			pre.setString(17, st.getType());
			
			if(st.getPhotopath() != null)
				pre.setBlob(18, new FileInputStream(new File(st.getPhotopath())));
			else{
				pre.setString(18, null);
			}
//			System.out.println(sql);
			counts = pre.executeUpdate();
			System.out.println(counts);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
	    {
	        this.closeConnection();
	    }
		return counts;
	}
	
	
	/*
	 * 从数据库中读取流文件
	 */
	public InputStream getPhoto(String id) throws SQLException, IOException {
		
		this.getConnected();
		String sql = "select 学生照片 from student where ID = ?";
		try{
			pre = conn.prepareStatement(sql);
			pre.setString(1, id);
			res = pre.executeQuery();
			System.out.println(sql + id);
			if (res.next()) {
				Blob bo = res.getBlob(1);
				BufferedInputStream ins = new BufferedInputStream(
						bo.getBinaryStream());
				int count = (int) bo.length();
				byte[] bt = new byte[count];
				ins.read(bt, 0, count);
				
				System.out.println("MysqlDAO：找到照片");
				return new ByteArrayInputStream(bt);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
	    {
	        this.closeConnection();
	    }
		System.out.println("MysqlDAO：没有找到照片");
		return null;
	}
	
	
	/**
	 * 2016-12-11 14:47:46
	 * @param student
	 * @return
	 * 还并没有完成，只是写了个示例insert
	 */
	public int insertRecordtest(Student student)
	{
		int counts = -1;
		this.getConnected();
		try{
			String sql = "insert into student(姓名,身份证号,一卡通图书证号,性别,民族,部门名称,部门代码,学生照片) values(?,?,?,?,?,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, "李白");
			pre.setString(2, "142727199508300314");
			pre.setString(3, "090001");
			pre.setString(4, "男");
			pre.setString(5, "苗");
			pre.setString(6, "铁道部9班");
			pre.setString(7, "C90");
			pre.setBlob(8, new FileInputStream(new File("C:\\Users\\nokan\\Desktop\\1.png")));
//			System.out.println(sql);
			counts = pre.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
	    {
	        this.closeConnection();
	    }
		return counts;
	}
	
	/*
	 * 新建连接
	 */
	public void getConnected()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接Mysql数据库！");
	        String url = "jdbc:mysql:" + "//127.0.0.1:3306/hit";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "root";// 用户名,系统默认的账户名
	        String password = "121386";// 你安装时选设置的密码
	        conn = DriverManager.getConnection(url, user, password);// 获取连接
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
            System.out.println("Mysql数据库连接已关闭！");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	/*
	 * 连接和结果集等
	 */
	Connection conn = null;	// 创建一个数据库连接
	Statement stmt = null;
	PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
	ResultSet res  = null;	// 创建一个结果集对象
}
