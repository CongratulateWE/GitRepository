package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Entity.Reader;
//import net.sf.json.JSONObject;
import com.alibaba.fastjson.*;

public class test {
	public static void main(String[] args) throws SQLException, IOException
	{
		Reader reader = new Reader();
		ReadersDAO rd = new ReadersDAO();
//		rd.getConnect();
//		System.out.println(rd.deleteRecord());
//		System.out.println(rd.updateRecord());
//		System.out.println(rd.insertRecord(reader));
//		System.out.println(rd.getPhoto(""));
		
//		rd.selectReadersById("09120130");
		
		/*String g = null;
		String g2 = " ";
		System.out.println(g==""?null:g);
		System.out.println(g2==""?null:g2);
		
		System.out.println(g2=="");*/
		
		for(int i=10;i<60;i++)
		{
			System.out.print("res.getString("+i+"), ");
			if(i%6 == 0)
				System.out.println();
		}
	}
}
