package action;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import DAO.MysqlDAO;
import DAO.ReadersDAO;
import Entity.Student;

public class MysqlAction extends ActionSupport {
	ArrayList<Student> StudentList;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	String lib_id;	
	String page;
	String pageSize;
	String josnStr;
	String new_lib;
	private File upload;
	
	public String searchPage(){
    	
    	dataMap.clear();
    	page = page.split(",")[0];
    	System.out.println("MysqlAction: searchPage: p = " + page + " s = "+ pageSize);
		
    	MysqlDAO msd = new MysqlDAO();
    	StudentList = msd.selectRecordsByPage(Integer.parseInt(page),Integer.parseInt(pageSize));

    	Student[] sta = new Student[StudentList.size()];
    	StudentList.toArray(sta);
    	
		dataMap.put("rows", sta);
		dataMap.put("total", 27587);
		
		josnStr = JSONObject.toJSONString(dataMap);		
		System.out.println("json: " + josnStr);
    	return SUCCESS;
    }

	 /*
     * 通过lib_id进行检索，可以考虑改为用一个键值对进行检索。
     */
    public String selectByid()
    {
    	dataMap.clear();
		MysqlDAO msd = new MysqlDAO();
		StudentList = msd.selectRecordById(lib_id);
		dataMap.put("total", StudentList.size());
		dataMap.put("rows", StudentList);
		
		System.out.println("Actiion: " + dataMap.toString());

    	return SUCCESS;
    }
    
    public String updateRecord()
    {
    	MysqlDAO msd = new MysqlDAO();
		int count = msd.updateRecord(lib_id, new_lib);
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
    
    public String showDetails()
    {
//    	Reader reader = new Reader();
//    	ReadersDAO rd = new ReadersDAO();
//		ReaderList = rd.selectReaderDetailssById(lib_id);
    	MysqlDAO msd = new MysqlDAO();
    	StudentList = msd.selectRecordById(lib_id);
		ServletActionContext.getRequest().setAttribute("student", StudentList.get(0));
		
    	return SUCCESS;
    }
    
    /*
	 * 通过lib_id返回photo
	 */
	public InputStream getPhoto() throws Exception{
		MysqlDAO msd = new MysqlDAO();
//		ReadersDAO rd = new ReadersDAO();
		System.out.println("ID:" + lib_id);
		return msd.getPhoto(lib_id);
	}
	
	public String uploadPhoto()
	{
		 	System.out.println("PhotoAction, File Path:" + upload);
	        ReadersDAO rd = new ReadersDAO();
	        int c = rd.insertPhoto(lib_id, upload);
	        System.out.println("PhotoAction, 添加图片: " + c);
	        if(c >= 0)
	        	return "success";
	        else
	        	return "error";
	}
	
	
	
	public ArrayList<Student> getStudentList() {
		return StudentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		StudentList = studentList;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getJosnStr() {
		return josnStr;
	}

	public void setJosnStr(String josnStr) {
		this.josnStr = josnStr;
	}

	public String getLib_id() {
		return lib_id;
	}

	public void setLib_id(String lib_id) {
		this.lib_id = lib_id;
	}

	public String getNew_lib() {
		return new_lib;
	}

	public void setNew_lib(String new_lib) {
		this.new_lib = new_lib;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	
}
