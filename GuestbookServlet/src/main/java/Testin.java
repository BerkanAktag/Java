import java.sql.SQLException;
import java.util.List;

public class Testin {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		GuestBookDao bookDao = new GuestBookDao("jdbc:mysql://noelvaes.eu/GuestBookDB",
				"student", "student123");
		List<GuestBookBean> list = bookDao.getGuestBookItems();
		
		for (GuestBookBean bean : bookDao.getGuestBookItems()) {
			
			System.out.print(bean.getDate());
			System.out.print(bean.getName());
			System.out.print(bean.getMessage());
			System.out.println();
		}
	}

}
