package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import DAO.ReadersDAO;
import Entity.Reader;

public class InsertReadersAction extends ActionSupport implements ModelDriven<Reader> {
	Reader reader = new Reader();
	
	public String execute() throws Exception {
		ReadersDAO rd = new ReadersDAO();
//		System.out.println("hello, insertAction");
		System.out.println("address: " + reader.getAddress() + "date: " + reader.getStartDate() + reader.getName());
		System.out.println("insertAction: " + reader.toString());
//		rd.insertRecord(reader);
		int counts = rd.insertRecord2(reader);
		if(counts > 0)
			return SUCCESS;
		else
			return ERROR;
	}
	
	@Override
	public Reader getModel() {
		// TODO Auto-generated method stub
		return reader;
	}
}
