import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.ReadersDAO;
import Entity.*;

public class getReaders  extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		
		Reader reader = new Reader();
		ReadersDAO rd = new ReadersDAO();
		rd.getConnect();
		
		response.sendRedirect("result.jsp");
	}

}
