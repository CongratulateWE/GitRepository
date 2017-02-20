package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import DAO.MysqlDAO;
import DAO.ReadersDAO;
import Entity.Student;

public class MysqlInsertAction extends ActionSupport implements ModelDriven<Student>{
	Student st = new Student();
	
	public String execute() throws Exception {
		
		ReadersDAO rd = new ReadersDAO();
		MysqlDAO msd = new MysqlDAO();
		
		System.out.println("MysqlinsertAction:");
//		System.out.println(reader.getAddress() + reader.getAddress() + reader.getName());
		System.out.println(st.toString());
		int counts = msd.insertRecord(st);
		System.out.println("Action: 插入行: " + counts);
	    return SUCCESS;
	}
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return st;
	}
	
	
}
