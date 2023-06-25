package BusRes;
import java.sql.*;
import java.sql.DriverManager;
public class BaseCon {
     
     public static void readRecords() throws Exception{
    	 String url ="jdbc:mysql://localhost:3306/BusReg";
    	 String userNmae ="root";
    	 String Password ="bharathi";
    	 String query ="Select * from bus";
    	 
    	 Connection con = DriverManager.getConnection(url, userNmae, Password);
    	 Statement st = con.createStatement();
    	 ResultSet rs = st.executeQuery(query);
    	 while(rs.next()) {
    		 System.out.println("Id is "+ rs.getInt(1));
    		 System.out.println("Ac/Non-AC "+ rs.getInt(2));
    		 System.out.println("Capacity is "+rs.getInt(3));
    	 }
    	 con.close();
     }
}
class DBcon{
	private static final String url = "jdbc:mysql://localhost:3306/BusReg";
	private static final String userNmae ="root";
	private static final String Password ="bharathi";
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, userNmae, Password);
 	}
}