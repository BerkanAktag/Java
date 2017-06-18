import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class GuestBookDao implements GuestBookDaoInterface{
	private String url;
	private String user;
	private String password;
	
	private Connection getConnection() throws SQLException{
		 return DriverManager.getConnection(url,user,password);
	}
	
	public List<GuestBookBean> getGuestBookItems() throws SQLException {
		String sql = "Select * from GuestBook";
		try(Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			try(ResultSet rs = stmt.executeQuery()){
				List<GuestBookBean> guestBookBeans = new ArrayList<>();
				
				while(rs.next()){
					GuestBookBean bean = new GuestBookBean(rs.getDate("Date")
							, rs.getString("Name"), rs.getString("Message"));
				
					guestBookBeans.add(bean);
				}
				return guestBookBeans;
			}
		}catch (SQLException ex) {
			ex.getMessage();
		}
		return null;
	}

	public void addGuestBookItem(GuestBookBean item) {
		
	}
	
	public GuestBookDao(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	public GuestBookDao(){
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
