import java.sql.SQLException;
import java.util.List;

public interface GuestBookDaoInterface{
	public List<GuestBookBean>  getGuestBookItems() throws SQLException;
	public void addGuestBookItem(GuestBookBean item);
}
