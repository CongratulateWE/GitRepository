package action;

import java.io.File;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

import DAO.ReadersDAO;

public class PhotoAction extends ActionSupport {

    private File upload;
    String lib_id;
/*
 * 添加了控制跳转
 * @see com.opensymphony.xwork2.ActionSupport#execute()
 */
	
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
	
	/*
	 * 通过lib_id返回photo
	 */
	public InputStream getPhoto() throws Exception{  
		ReadersDAO rd = new ReadersDAO();
		System.out.println("libid" + lib_id);
		return rd.getPhoto(lib_id);
	}  
	
/*
 * Getter and Setter
 */
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	public String getLib_id() {
		return lib_id;
	}

	public void setLib_id(String lib_id) {
		this.lib_id = lib_id;
	}
}

