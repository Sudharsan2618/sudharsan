package BusRes;
import java.sql.*;
import java.util.Date;
public class BookingDAO {
        public int getBookedCount(int busno,Date date) throws SQLException{
        	String query = "Select count(Name) from booking where bus_no = ? and travel_date = ?";
        	Connection con = DBcon.getConnection();
          PreparedStatement	pst = con.prepareStatement(query);
          java.sql.Date sqldate = new java.sql.Date(date.getTime());
          pst.setInt(1, busno);
          pst.setDate(2, sqldate);
          ResultSet rs = pst.executeQuery();
          rs.next();
          return rs.getInt(1);
        }
        public void addBooking(Booking booking) throws SQLException {
        	String query = "Insert into booking value(?,?,?)";
        	Connection con = DBcon.getConnection();
        	PreparedStatement pst = con.prepareStatement(query);
        	pst.setString(1, booking.Name);
        	pst.setInt(2,booking.busno);
        	java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        	pst.setDate(3, sqldate);
        	int a=pst.executeUpdate();
        }
}