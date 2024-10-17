package day2_2;
import java.sql.*;
public class JDBCDemo1 
{
 public static void main(String[] args) 
 {
	 try
	 {
	  //Step 1:Load the driver
 	  Class.forName("oracle.jdbc.driver.OracleDriver");
  	  //Step 2:Create connection  
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@AGNI:1521:Oracle12c","java","java");
	  //Step 3:Handle the exceptions
	  //Step 4:Create SQL Query
	  String sql="select * from emp";
	  //Step 5:Associate SQL Query with connection.
	  Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	  //Step 6:Get the Result
	  ResultSet rs=stmt.executeQuery(sql);
	  //Step 7:Process the Result
	  System.out.println("Result Set (fw):");
	  while(rs.next())
	  {
		  System.out.println(" "+rs.getInt("eid")+" "+rs.getString(2)+" "+rs.getInt(3));
	  }
	  System.out.println("Result Set (Rev):");
	  while(rs.previous())
	  {
		  System.out.println(" "+rs.getInt("eid")+" "+rs.getString(2)+" "+rs.getInt(3));
	  }
	  
	  // MOVE FIRST
	 rs.first();
	  System.out.println(" "+rs.getInt("eid")+" "+rs.getString(2)+" "+rs.getInt(3));
	  rs.last();
	  System.out.println(" "+rs.getInt("eid")+" "+rs.getString(2)+" "+rs.getInt(3)); 
	  rs.relative(-2);
	  System.out.println(" "+rs.getInt("eid")+" "+rs.getString(2)+" "+rs.getInt(3));
	  rs.absolute(3);
	  System.out.println(" "+rs.getInt("eid")+" "+rs.getString(2)+" "+rs.getInt(3));
	  
	  
	  
	  //Step 8:Close the Connection
	  con.close();
	 }
	 catch(SQLException e) 
	 {
	   e. printStackTrace();
	 }
	 catch(ClassNotFoundException e) 
	 {
	   e.printStackTrace();
	 }
 }//end main
}//end class
