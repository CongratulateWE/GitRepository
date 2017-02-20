package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import DAO.MysqlDAO;
import DAO.ReadersDAO;
import Entity.Reader;

public class MysqlDeleteAction extends ActionSupport{
	private Map<String, Object> dataMap;
	ArrayList<Reader> ReaderList;	//
	
	private String lib_id;			//采用借书证号为键的删除方式
	
	public MysqlDeleteAction() {
		dataMap = new HashMap<String, Object>();
	}

	public String execute() throws Exception {		
		MysqlDAO msd = new MysqlDAO();
		int count = msd.deleteRecordById(lib_id);
		
		System.out.println("MysqlAction: 删除？行--" + count);
		if(count >= 0)
		{
			dataMap.put("success", true);
		}
		else{
			dataMap.put("success", false);
			dataMap.put("msg", "未能删除成功");
		}
	    return SUCCESS;
	}

	public String getLib_id() {
		return lib_id;
	}

	public void setLib_id(String lib_id) {
		this.lib_id = lib_id;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}
