package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.alibaba.fastjson.*;
import DAO.ReadersDAO;
import Entity.Reader;
import Entity.User;
//import net.sf.json.JSONObject;

public class getReadersAction  extends ActionSupport {
	ArrayList<Reader> ReaderList;
	private Map<String, Object> dataMap;
	String lib_id;
	String page;
	String pageSize;
	String josnStr;
	
	
	public String getJosnStr() {
		return josnStr;
	}

	public void setJosnStr(String josnStr) {
		this.josnStr = josnStr;
	}

	/*
	 * 测试分页的
	 */
	
	
	public String pagesearch()
    {
    	dataMap.clear();
//		Reader reader = new Reader();
    	System.out.println("hellopage");
		dataMap.put("msg", "I got it " + page +" "+ pageSize);
		System.out.println(dataMap.toString());
		return SUCCESS;
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

	/** 
     * 构造方法 
     */  
    public getReadersAction() {  
        //初始化Map对象  
        dataMap = new HashMap<String, Object>();
    }
    
	/** 
     * 测试通过action以视图方式返回JSON数据 
     * @return 
     */  
    public String testByJSP() {
        Reader user = new Reader();
        user.setName("张三");
        user.setReader_id("16137036");
        JSONObject jsonObject=new JSONObject();
//        jsonObject.accumulate("user", user);
//        jsonObject.accumulate("success", true);
        //这里在request对象中放了一个data，所以struts的result配置中不能有type="redirect"  
        ServletActionContext.getRequest().setAttribute("data", jsonObject);  
        return SUCCESS;  
    };
    
    public String showDetails()
    {
//    	Reader reader = new Reader();
    	ReadersDAO rd = new ReadersDAO();
		ReaderList = rd.selectReaderDetailssById(lib_id);
		ServletActionContext.getRequest().setAttribute("reader", ReaderList.get(0));
		
    	return SUCCESS;
    }
    
    /** 
     * 测试通过action以Struts2默认方式返回JSON数据 
     * 并不能用
     * @return 
     */      
    public String testByAction() {
		// dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据
		dataMap.clear();
		User user = new User();
		user.setId("123");
		user.setName("JSONActionStruts2");
		user.setPassword("123");
		user.setSay("Hello world !");
		
		dataMap.put("user", user);
		// 放入一个是否操作成功的标识
		dataMap.put("success", true);
		// 返回结果
		return SUCCESS;
	}
	
    
    
    /*
     * (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String json()
    {
    	dataMap.clear();
//		Reader reader = new Reader();
		ReadersDAO rd = new ReadersDAO();
		ReaderList = rd.selectReaders();
		
		dataMap.put("rows", ReaderList);
		dataMap.put("total", ReaderList.size());
		return SUCCESS;
    }
    
    /*
     * 通过lib_id进行检索，可以考虑改为用一个键值对进行检索。
     */
    public String selectByid()
    {
    	dataMap.clear();
		ReadersDAO rd = new ReadersDAO();
		ReaderList = rd.selectReadersById(lib_id);
		dataMap.put("total", ReaderList.size());
		dataMap.put("rows", ReaderList);
		
		System.out.println("Actiion: " + dataMap.toString());

    	return SUCCESS;
    }
    
    public String searchPage(){
    	
    	dataMap.clear();
//		Reader reader = new Reader();
    	System.out.println("Action: searchPage: p = " + page + " s = "+ pageSize);
		
		ReadersDAO rd = new ReadersDAO();
		ReaderList = rd.selectReadersByPage(Integer.parseInt(page),Integer.parseInt(pageSize));

		dataMap.put("rows", ReaderList);
		dataMap.put("total", rd.countRecord());
		
		josnStr = JSONObject.toJSONString(dataMap);		
		System.out.println("json: " + josnStr);
    	return SUCCESS;
    }
    
	public String execute() throws Exception {
		dataMap.clear();
		Reader reader = new Reader();
		ReadersDAO rd = new ReadersDAO();
		ReaderList = rd.selectReaders();
		JSONObject jsonObject=new JSONObject();
//        jsonObject.accumulate("Readers", ReaderList);
//        jsonObject.accumulate("success", true);
        ServletActionContext.getRequest().setAttribute("data", jsonObject);  
	    return SUCCESS;
	}
	
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public ArrayList<Reader> getReaderList() {
		return ReaderList;
	}

	public void setReaderList(ArrayList<Reader> readerList) {
		ReaderList = readerList;
	}

	public String getLib_id() {
		return lib_id;
	}

	public void setLib_id(String lib_id) {
		this.lib_id = lib_id;
	}
	
}
