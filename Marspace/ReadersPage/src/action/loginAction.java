package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport{
	
	private String account;
	private String password;
	private String message;
	private String role = "normal";
	private String real_account; 
	private String real_password;
/*
 * 执行用户验证
 */
	public String execute() throws Exception {
	/*
	 * 读取文件,这个我暂时不知道文件应该放在哪里。。
	 */
		File file;
		String returntype;
		if(role.equals("root"))
		{
			file = new File("C:/root.txt");
			returntype = "root";
		}
		else{
			file = new File("C:/account.txt");
			returntype = "normal";
		}
		BufferedReader buff = new BufferedReader(new FileReader(file));		
		String temp = buff.readLine().toString();
		String[] stra = temp.split(",");
		real_account = stra[0];
		real_password = stra[1];
		buff.close();
		
//		String real_account = "admin";
//		String real_password = "123456";
		
		if(real_account.equals(account) && real_password.equals(password))
		{
			message = account + "登录成功";
			System.out.println(message);
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("role", role);
			session.setAttribute("account", account);
		}
		else{
			message = account + "登录失败，用户名或密码错误";
			System.out.println(message);
			return INPUT;
		}
			
		return returntype;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
