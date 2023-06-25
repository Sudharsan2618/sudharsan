package BusRes;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String Name; 
    int busno;
    java.util.Date date;
    Scanner sp = new Scanner(System.in);
    Booking(){
    	System.out.println("Enter your name : ");
    	Name = sp.next();
    	System.out.println("Enter Bus.No : ");
    	busno = sp.nextInt();
    	System.out.println("Enter date dd-mm-yyyy : ");
    	String dateInput = sp.next();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
        try{
    		
			date = dateFormat.parse(dateInput);
    	}
    	catch(ParseException e){
    		e.printStackTrace();
    	}
}
    public boolean isAvailable() throws SQLException{
    	BusDAO busdao = new BusDAO();
    	int capacity = busdao.getCapacity(busno);
    	BookingDAO bookingDAO = new BookingDAO();
    	
    	int booking = bookingDAO.getBookedCount(busno, date);
    	return booking < capacity;
    }

}