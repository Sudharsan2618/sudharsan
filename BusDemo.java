package BusRes;
import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;
public class BusDemo {
   public static void main(String [] args)throws SQLException{
	   BusDAO busDAO = new BusDAO();
	   busDAO.displayBusInfo();
	   int userOpt = 1;
	   Scanner sp = new Scanner(System.in);
	   System.out.println("Enter 1 for Booking or 2 for Exit");
	   userOpt = sp.nextInt();
	   if(userOpt == 1) {
		   Booking booking = new Booking();
	 if(booking.isAvailable()){
		 BookingDAO bookingDAO = new BookingDAO();
		 bookingDAO.addBooking(booking);
		 System.out.println("Your Booking is Confirmed");
	 }
	 else {
		 System.out.print("Sorry,This bus is fully booked.");
	 }
	 }
   }