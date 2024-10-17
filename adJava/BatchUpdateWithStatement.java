package day2_1;
import  java.sql.*;
public class BatchUpdateWithStatement 
{
  public static void main(String[] args) throws SQLException 
  {
	  Connection conn=null;
	try
	 {
	 	Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@AGNI:1521:Oracle12c","java","java");
		Statement stmt=conn.createStatement();
		conn.setAutoCommit(false);
		
		stmt.addBatch("Insert into cust VALUES(106,'Hrashad','Pune')");
		stmt.addBatch("Insert into cust VALUES(107,'Kiran','Nasik',12000)");
		stmt.addBatch("Insert into cust VALUES(108,'Anil','Nasik')");
		 int []updateCounts=stmt.executeBatch();
		System.out.println("batch updated "+updateCounts.length+" Record");
		conn.commit();
	 }
	 catch(Exception e)
	 {
	  System.out.println(e);
	 // conn.rollback();
	 }

	}

}
