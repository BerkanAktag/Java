import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GuestBook")
public class BookServlet extends HttpServlet{
	private GuestBookDao bookDao;
	public void init(){
		bookDao = new GuestBookDao("jdbc:mysql://noelvaes.eu/GuestBookDB",
				"student", "student123");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Guest book service</title></head>");
		out.println("<body>");
		
			try {
				for (GuestBookBean bean : bookDao.getGuestBookItems()) {
					
					out.println(bean.getDate());
					out.println(bean.getName());
					out.println(bean.getMessage());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.println("</body>");
			
			out.println("</html>");
		
		//<tr><td>"+);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
}
