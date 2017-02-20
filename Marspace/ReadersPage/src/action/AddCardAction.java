package action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import DAO.MysqlDAO;
import DAO.ReadersDAO;
import Entity.*;

public class AddCardAction extends ActionSupport{
	String id_card;		//这里代表的是搜索的值	身份证号
	String campus_card;	//这里代表了待修改的值	一卡通图书证号
	String value;
	String indexvalue;
	private Map<String, Object> dataMap;
	
	public AddCardAction() {
		this.dataMap = new HashMap<String, Object>();;
	}

	/**
	 * 学生补卡Action
	 */
	public String execute()
	{
		int count1,count2;
		ReadersDAO rd = new ReadersDAO();
		MysqlDAO msd = new MysqlDAO();
		
		System.out.println("AddCardAction: idcard=" + id_card + " campus_card=" + campus_card);
		
		count1 = msd.updateRecord("一卡通图书证号", campus_card, "身份证号", id_card);
		count2 = rd.updateRecord("借书证号", campus_card, "身份证号", id_card);
		if(count1 > 0&& count2 >0)
		{
			dataMap.put("success", true);
			dataMap.put("msg", "修改Mysql数据库记录"+count1+"条,Oracle数据库记录"+count1+"条");
		}
		else{
			dataMap.put("success", false);
			if(count1 > 0)
				dataMap.put("msg", "插入Mysql数据库成功，Oracle数据库失败");
			else if(count2 > 0)
				dataMap.put("msg", "插入Oracle数据库成功，Mysql数据库失败");
			else
				dataMap.put("msg", "插入Oracle数据库失败，Mysql数据库失败");
		}
		return SUCCESS;
	}
	
	public String check(){
		ReadersDAO rd = new ReadersDAO();
		MysqlDAO msd = new MysqlDAO();
		System.out.println("addcardAction: id_card = " + id_card);
		Student stu = msd.selectRecordByDiyid("身份证号", id_card).get(0);
		Reader reader = rd.selectReadersByDiyid("身份证号", id_card).get(0);
		
		if(reader != null && stu != null)
		{
			dataMap.put("success", true);
			dataMap.put("msg", "找到用户");
		}
		else{
			dataMap.put("success", false);
			if(reader != null)
				dataMap.put("msg", "在Mysql数据库中没有找到用户");
			else if(stu != null)
				dataMap.put("msg", "在Oracle数据库中没有找到用户");
			else
				dataMap.put("msg", "没有找到用户");
		}
		return SUCCESS;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getCampus_card() {
		return campus_card;
	}

	public void setCampus_card(String campus_card) {
		this.campus_card = campus_card;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIndexvalue() {
		return indexvalue;
	}

	public void setIndexvalue(String indexvalue) {
		this.indexvalue = indexvalue;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
}
