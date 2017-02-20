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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entity.Reader;

/**
 * 修改了selectReadersByPage，解决了首列显示是自增序号的问题，现在可以正确的对应显示数据了
 * @author nokan
 *
 */

public class ReadersDAO { 
	
	/**
	 * 一个测试代码，已经不再用了
	 */
	public void getConnect()
	{		
		try
		{
			getConnected();
			
	        String sql = "select * from \"读者库\" where 姓名 = ?";// 预编译语句，“？”代表参数
	        pre = conn.prepareStatement(sql);// 实例化预编译语句
	        pre.setString(1, "张彤");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        res = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	        
	        ResultSetMetaData meta = res.getMetaData();
	        int columns = meta.getColumnCount();
	        //显示列,表格的表头
	        for(int i=1;i<=columns;i++)
	        {
		        System.out.print(meta.getColumnName(i));
		        System.out.print("\t");
	        }
	        System.out.println();
	        while (res.next())	// 当结果集不为空时
	        {
//	            System.out.println("name:" + res.getString(2) + "押金" + res.getString(14));
	        	for(int i = 1; i< columns;i++)
	        	{
	        	 	if(i != 39)
	        		{
		        	    System.out.print(res.getString(i));
		        	    System.out.print(",");
	        		}
	        	}
	        	System.out.println();
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
	}
	
	/*
	 * 要不改成传入sql返回数据,后面改成了搜索一页数据的方式，这个不再需要了
	 */
	public ArrayList<Reader> selectReaders()
	{
		getConnected();
		ArrayList<Reader> ReaderList = new ArrayList<Reader>();
		try{
			String sql = "select * from \"读者库\"";
			
	        pre = conn.prepareStatement(sql);// 实例化预编译语句
	        res = pre.executeQuery();// 执行查询，注意括号中不需要再加参数	
	        
	        ResultSetMetaData meta = res.getMetaData();
	        int columns = meta.getColumnCount();
	        
	        for(int i = 0;i<100;i++)
	        {
	        	res.next();
	        	Reader reader = new Reader(res.getString(1),res.getString(2),res.getString(3),res.getString(4),
	        			res.getString(5),res.getString(6));
	        	ReaderList.add(reader);
	        }
		} catch (Exception e)
	    {
//			System.out.println(e.getMessage());
	        e.printStackTrace();
	    }
		finally
	    {
	        this.closeConnection();
	    }
		return ReaderList;
	}
	
	/**
	 * 采用分页方式搜索数据库
	 * @param page
	 * @param pageSize
	 * @return
	 * 2016年12月9日 23:32:27 
	 * --修改了sql语句，使之不再搜索所有列。
	 * --修改了Reader的赋值，现在可以正确的对应属性了。	
	 */
	public ArrayList<Reader> selectReadersByPage(int page, int pageSize)
	{
		getConnected();
		System.out.println("DAO: selectReadersByPage:p=" + page +" s="+ pageSize);
		ArrayList<Reader> ReaderList = new ArrayList<Reader>();
		try{
			String sql = "select 借书证号,读者条码,姓名,性别,身份证号, 读者级别, 级别代码,单位代码, 单位,主键码, 馆键码"
					+ " from (select rownum as rn, \"读者库\".* from \"读者库\" ) "
					+ "where rn > " + (page-1) * pageSize + " and rn <=" + page * pageSize;
			
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			
			while (res.next())
	        {
	        	Reader reader = new Reader(res.getString(1),res.getString(2),res.getString(3),res.getString(4),
	        			res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11));
	        	System.out.println("DAO:" + reader.toString());
	        	ReaderList.add(reader);
	        }
			
		}catch (Exception e)
	    {
	        e.printStackTrace();
	    }
		finally
	    {
	        this.closeConnection();
	    }
		
		return ReaderList;
	}
	
	/**
	 * 通过lib_id来查找用户，返回一个具有单元素的arraylist
	 * @param id
	 * @return ArrayList,其中Reader具有主要元素的信息
	 */
	public ArrayList<Reader> selectReadersById(String id)
	{
		getConnected();
		System.out.println("selectReadersById:" + id);
		ArrayList<Reader> ReaderList = new ArrayList<Reader>();
		try{
			String sql = "select 借书证号,读者条码,姓名,性别,身份证号, 读者级别, 级别代码, 单位代码, 单位, 主键码, 馆键码"
					+ " from \"读者库\" where 借书证号= ?";// 预编译语句，“？”代表参数
			
	        pre = conn.prepareStatement(sql);// 实例化预编译语句
	        pre.setString(1, id);			// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        res = pre.executeQuery();		// 执行查询，注意括号中不需要再加参数	
	        
	        res.next();
	        {
	        	//借书证号,读者条码,姓名,性别,身份证号, 读者级别, 级别代码, 单位代码, 单位, 主键码, 馆键码
	        	Reader reader = new Reader(res.getString(1),res.getString(2),res.getString(3),res.getString(4),	res.getString(5),
	        			res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString("主键码"),res.getString("馆键码"));
	        	
	        	System.out.println(reader.toString());
	        	ReaderList.add(reader);
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
	
	public ArrayList<Reader> selectReadersByDiyid(String column, String id)
	{
		getConnected();
		System.out.println("selectReadersById:" + id);
		ArrayList<Reader> ReaderList = new ArrayList<Reader>();
		try{
			String sql = "select 借书证号,读者条码,姓名,性别,身份证号, 读者级别, 级别代码, 单位代码, 单位, 主键码, 馆键码"
					+ " from \"读者库\" where " + column + " = ?";// 预编译语句，“？”代表参数
			
	        pre = conn.prepareStatement(sql);// 实例化预编译语句
	        pre.setString(1, id);			// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        res = pre.executeQuery();		// 执行查询，注意括号中不需要再加参数	
	        
	        res.next();
	        {
	        	//借书证号,读者条码,姓名,性别,身份证号, 读者级别, 级别代码, 单位代码, 单位, 主键码, 馆键码
	        	Reader reader = new Reader(res.getString(1),res.getString(2),res.getString(3),res.getString(4),	res.getString(5),
	        			res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString("主键码"),res.getString("馆键码"));
	        	
	        	System.out.println(reader.toString());
	        	ReaderList.add(reader);
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
	 * 修改记录，实际上没有用到修改用户信息的功能。测试成功
	 */
	
	/**
	 * 通过借书证号查找用户的详细信息
	 * @param id
	 * @return
	 */
	public ArrayList<Reader> selectReaderDetailssById(String id)
	{
		getConnected();
		System.out.println("selectReaderDetailssById:" + id);
		ArrayList<Reader> ReaderList = new ArrayList<Reader>();

		try{
			String sql = "select * from \"读者库\" where 借书证号= ?";// 预编译语句，“？”代表参数
			
	        pre = conn.prepareStatement(sql);// 实例化预编译语句
	        pre.setString(1, id);			// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        res = pre.executeQuery();		// 执行查询，注意括号中不需要再加参数	
	        
	        res.next();
	        {
	        	//中间少了照片，第39列。
	        	Reader reader = new Reader(res.getString(1),res.getString(2),res.getString(3),res.getString(4),	res.getString(5),
	        			res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10), res.getString(11), res.getString(12), 
	        			res.getString(13), res.getString(14), res.getString(15), res.getString(16), res.getString(17), res.getString(18), 
	        			res.getString(19), res.getString(20), res.getString(21), res.getString(22), res.getString(23), res.getString(24), 
	        			res.getString(25), res.getString(26), res.getString(27), res.getString(28), res.getString(29), res.getString(30), 
	        			res.getString(31), res.getString(32), res.getString(33), res.getString(34), res.getString(35), res.getString(36), 
	        			res.getString(37), res.getString(38), 					 res.getString(40), res.getString(41), res.getString(42), 
	        			res.getString(43), res.getString(44), res.getString(45), res.getString(46), res.getString(47), res.getString(48), 
	        			res.getString(49), res.getString(50), res.getString(51), res.getString(52), res.getString(53), res.getString(54), 
	        			res.getString(55), res.getString(56), res.getString(57), res.getString(58),res.getString(59), res.getString(60), res.getString(60)	        			
	        			);
	        	
	        	System.out.println(reader.toString());
	        	ReaderList.add(reader);
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
	
	
	
	public int updateRecord()
	{
		int counts = -1;	//修改记录数
		getConnected();
		try{
			String sql = "update \"读者库\" set 姓名 = '张彤6' where 姓名 = '张彤'";
//			String sql = "update \"读者库\" set 姓名 = '张彤5' where 借书证号 = '09011103'";
			pre = conn.prepareStatement(sql);
			System.out.println("1");
			counts = pre.executeUpdate();
			System.out.println("2");
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
	 * @return 成功操作的列数
	 */
	public int updateRecord(String column, String value, String indexcolumn, String indexvalue)
	{
		int counts = -1;
		this.getConnected();
		String sql = "update 读者库 set " + column + " = ? where " + indexcolumn + " = ?";
		System.out.println("DAO: " + sql);
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
	 * 插入操作，测试成功，再混上前端传过来的数据有点麻烦
	 */
	public int insertRecord(Reader reader)
	{
		int counts = -1;
		getConnected();
		try{
			//String sql = "INSERT INTO \"读者库\" (借书证号, 读者条码,姓名, 性别, 身份证号, 读者级别, 级别代码, 单位代码, 单位, 电话, 联系地址, 邮政编码, EMAIL, 押金, 可外借, 已外借, 发证日期, 失效日期, 挂失注销, 欠罚款, 欠赔款, 上次到馆时间, 上月外借册数, 本月外借册数, 今年外借册数, 去年外借册数, 累计外借册数, 累计超期册数, 累计交罚款, 累计赔款, 本月到馆次数, 上月到馆次数, 今年到馆次数, 去年到馆次数, 累计到馆次数, 民族, 阅览室外借, 代理人, 余额, 总计, 免费机时, 特借押金, 已借特借书, 主键码, 馆键码, 停用天数, 预约违章次数, 服务费, 恶意推荐次数) VALUES ('21011114', '2101110314', '张彤3', '男', ' ', '三年制学生', 'B', 'C09', '09铁工11班', ' ', ' ', ' ', ' ', '0', '8', '0', TO_DATE('2009-10-23 11:03:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2012-06-20 11:02:00', 'YYYY-MM-DD HH24:MI:SS'), ' ', '0', '0', TO_DATE('2009-11-05 15:22:17', 'YYYY-MM-DD HH24:MI:SS'), '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', ' ', '0', ' ', '0', '0', '0', '0', '0', '924', '1', '0', '0', '0', '0')";
			String sql = "INSERT INTO \"读者库\" (借书证号, 读者条码,姓名, 性别, 身份证号, 读者级别, 级别代码, 单位代码, 单位, 电话, 联系地址, 邮政编码, EMAIL, 押金, 可外借, 已外借, 发证日期, 失效日期, 挂失注销, 挂失日期, 欠罚款, 欠赔款, 上次到馆时间, 上月外借册数, 本月外借册数, 今年外借册数, 去年外借册数, 累计外借册数, 累计超期册数, 累计交罚款, 累计赔款, 本月到馆次数, 上月到馆次数, 今年到馆次数, 去年到馆次数, 累计到馆次数, 密码,备注,民族, 阅览室外借, 代理人, 余额, 总计, 免费机时, 特借押金, 已借特借书, 主键码, 馆键码, 停用日期, 停用天数, 班级, 预约违章次数, 服务费, 恶意推荐次数, 年级, 专业, 系别, 手机, ISSYNC) VALUES (" + reader.iString() + ")";
//			String sql = "INSERT INTO \"读者库\" (借书证号, 读者条码,姓名, 性别, 身份证号, 读者级别, 级别代码, 单位代码, 单位, 电话, 联系地址, 邮政编码, EMAIL, 押金, 可外借, 已外借, 发证日期, 失效日期, 挂失注销, 欠罚款, 欠赔款, 上次到馆时间, 上月外借册数, 本月外借册数, 今年外借册数, 去年外借册数, 累计外借册数, 累计超期册数, 累计交罚款, 累计赔款, 本月到馆次数, 上月到馆次数, 今年到馆次数, 去年到馆次数, 累计到馆次数, 民族, 阅览室外借, 代理人, 余额, 总计, 免费机时, 特借押金, 已借特借书, 主键码, 馆键码, 停用天数, 预约违章次数, 服务费, 恶意推荐次数) VALUES ('21011103', '21011103', '张彤3', '男', ' ', '三年制学生', 'B', 'C09', '09铁工11班', ' ', ' ', ' ', ' ', '0', '8', '0', TO_DATE('2009-10-23 11:03:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2012-06-20 11:02:00', 'YYYY-MM-DD HH24:MI:SS'), ' ', '0', '0', TO_DATE('2009-11-05 15:22:17', 'YYYY-MM-DD HH24:MI:SS'), '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', ' ', '0', ' ', '0', '0', '0', '0', '0', '924', '1', '0', '0', '0', '0')";
//			String sql = "INSERT INTO \"读者库\" (借书证号, 读者条码,姓名, 性别, 身份证号, 读者级别, 级别代码, 单位代码, 单位, 电话, 联系地址, 邮政编码, EMAIL, 押金, 可外借, 已外借, 发证日期, 失效日期, 挂失注销, 欠罚款, 欠赔款, 上次到馆时间, 上月外借册数, 本月外借册数, 今年外借册数, 去年外借册数, 累计外借册数, 累计超期册数, 累计交罚款, 累计赔款, 本月到馆次数, 上月到馆次数, 今年到馆次数, 去年到馆次数, 累计到馆次数, 民族, 阅览室外借, 代理人, 余额, 总计, 免费机时, 特借押金, 已借特借书, 主键码, 馆键码, 停用天数, 预约违章次数, 服务费, 恶意推荐次数) VALUES (" + reader.iString() + ")";

			System.out.println(sql);
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			
			System.out.println(2);
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
	
	public int insertRecord2(Reader re)
	{
		int counts = -1;
		
		this.getConnected();
		try{
			String sql = "insert into 读者库 values(?,?,?,?,?,?,?,?,?,?,	?,?,?,?,?,?,?,?,?,?,	?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?	,?,?,?,?,?,?,?,?,?,?	,?,?,?,?,?,?,?,?,?,?	,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, re.getLib_id());
			pre.setString(2, re.getReader_id());			
			pre.setString(3, re.getName());
			pre.setString(4, re.getGender());
			pre.setString(5, re.getId_card());			
			pre.setString(6, re.getLevel());
			pre.setString(7, re.getLevel_code());
			pre.setString(8, re.getDiv_code());
			pre.setString(9, re.getDivision());
			pre.setString(10, re.getTel());
			
			pre.setString(11, re.getAddress());
			pre.setString(12, re.getPost_code());
			pre.setString(13, re.getEmail());
			pre.setString(14, re.getDeposit());
			pre.setString(15, re.getBorrow_limit());
			pre.setString(16, re.getBorrowed());
//			pre.setString(17, "TO_DATE('" + re.getStartDate() + "', 'YYYY-MM-DD HH24:MI:SS')");
//			pre.setObject(17, "TO_DATE('" + re.getStartDate() + "', 'YYYY-MM-DD HH24:MI:SS')");
			if(re.getStartDate().equals("") )
				pre.setString(17, null);
			else				
				pre.setObject(17, new java.sql.Date(sdf.parse(re.getStartDate()).getTime()));
			if(re.getEndDate().equals("") )
				pre.setString(18, null);
			else				
				pre.setObject(18, new java.sql.Date(sdf.parse(re.getEndDate()).getTime()));
			
			pre.setString(19, re.getLock());
			
			if(re.getLockDate().equals(""))
				pre.setString(20, null);
			else
				pre.setObject(20, new java.sql.Date(sdf.parse(re.getLockDate()).getTime()));
			
			pre.setString(21, re.getFine());
			pre.setString(22, re.getCompensate());
			
			if(re.getLastDate().equals(""))
				pre.setString(23, null);
			else
				pre.setObject(23, new java.sql.Date(sdf.parse(re.getLastDate()).getTime()));
			
//			pre.setString(23, re.getLastDate());
			pre.setString(24, re.getLastMonthBrrowed());
			pre.setString(25, re.getThisMonthBrrowed());
			pre.setString(26, re.getThisYearBrrowed());
			pre.setString(27, re.getLastYearBrrowed());
			pre.setString(28, re.getTotalBrrowed());
			pre.setString(29, re.getTotalExpiryBooknum());
			
			pre.setString(30, re.getTotalPaiedfine());
			pre.setString(31, re.getTotalPaiedcompensate());
			pre.setString(32, re.getThisMonthVisited());
			pre.setString(33, re.getLastMonthVisited());
			pre.setString(34, re.getThisYearVisited());
			pre.setString(35, re.getLastYearVisited());
			pre.setString(36, re.getTotalVisited());
			pre.setString(37, re.getPassword());
			pre.setString(38, re.getRemark());
			if(re.getPhotopath() != null)
				pre.setBlob(39, new FileInputStream(new File(re.getPhotopath())));
			else
				pre.setString(39, null);			
			pre.setString(40, re.getRetain_info());
			
			pre.setString(41, re.getNationality());
			pre.setString(42, re.getReadingroomBrrowed());
			pre.setString(43, re.getAgent());
			pre.setString(44, re.getBalance());
			pre.setString(45, re.getTotal());
			pre.setString(46, re.getFreeHours());
			pre.setString(47, re.getSpecialBrrowedDeposit());
			pre.setString(48, re.getSpecialBrrowed());
			pre.setString(49, re.getPrimarykey());
			pre.setString(50, re.getLibkey());
			pre.setString(51, re.getFreezedDate());
			pre.setString(52, re.getFreezedDays());
			pre.setString(53, re.getClassnum());
			pre.setString(54, re.getBreaktime());
			pre.setString(55, re.getServicefee());
			pre.setString(56, re.getBadRecommendTimes());
			pre.setString(57, re.getGrade());
			
			pre.setString(58, re.getMajor());
			pre.setString(59, re.getDepartment());
			pre.setString(60, re.getPhone());
			pre.setString(61, re.getISSYNC());
			
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
	 * 删除记录，简单测试通过
	 * 通过读者证号进行删除
	 */
	public int deleteRecord(String lib_id)
	{
		int counts = -1;
		getConnected();
		try{
			String sql = "delete from \"读者库\" where 借书证号 = ?";
			
			pre = conn.prepareStatement(sql);
			pre.setString(1, lib_id);
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
	 * 统计数据记录总数，在换页的时候用到
	 */
	public int countRecord()
	{
		this.getConnected();
		int counts = 0;
		try{
			String sql = "select count(*) from \"读者库\"";
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			res.next();
			counts = res.getInt(1);
		}catch (Exception e)
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
	public InputStream getPhoto(String lib_id) throws SQLException, IOException {
		
		this.getConnected();
		String sql = "select 照片 from 读者库  where 借书证号=?";
		try{
			pre = conn.prepareStatement(sql);
			pre.setString(1, lib_id);
			res = pre.executeQuery();
			System.out.println(sql + lib_id);
			if (res.next()) {
				Blob bo = res.getBlob("照片");
				BufferedInputStream ins = new BufferedInputStream(
						bo.getBinaryStream());
				int count = (int) bo.length();
				byte[] bt = new byte[count];
				ins.read(bt, 0, count);
				
				System.out.println("DAO：找到照片");
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
		System.out.println("DAO：没有找到照片");
		return null;
	}
	
	/*
	 * 在指定的lib_id下插入一张图片
	 */
	public int insertPhoto(String lib_id, File upload)
	{
		int counts = -1;
		this.getConnected();
		String sql = "update 读者库 set 照片 = ? where 借书证号 = ?";
		System.out.println(sql + lib_id);
		try{
			pre = conn.prepareStatement(sql);
			pre.setBlob(1, new FileInputStream(upload));
			pre.setString(2, lib_id);
			
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
			Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");
	        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:system";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "moonzno";// 用户名,系统默认的账户名
	        String password = "123456";// 你安装时选设置的密码
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
	
	public static void main(String[] args)
	{
		ReadersDAO rd = new ReadersDAO();
//		rd.selectReaderDetailssById("14330129");
//		System.out.println(rd.updateRecord("身份证号", "142727", "姓名", "毛旭强"));
		System.out.println(rd.selectReaderDetailssById("14330129").get(0).toString());
	}
	
	Connection conn = null;	// 创建一个数据库连接
	Statement stmt = null;
	PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
	ResultSet res  = null;	// 创建一个结果集对象
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
}
