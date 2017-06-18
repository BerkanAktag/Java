import java.sql.Date;

public class GuestBookBean {

	private Date date;
	private String name;
	private String message;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public GuestBookBean(Date date, String name, String message) {
		this.date = date;
		this.name = name;
		this.message = message;
	}
	
	
}
