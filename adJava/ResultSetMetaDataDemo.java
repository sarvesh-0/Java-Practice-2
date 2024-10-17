package day2_3;
import java.sql.*;


public class ResultSetMetaDataDemo
{
  public static void main(String args[]) throws ClassNotFoundException
  {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	ResultSetMetaData resultsetmetadata=null;
	try
  	 {
	 Class.forName("oracle.jdbc.driver.OracleDriver");  
     con=DriverManager.getConnection("jdbc:oracle:thin:@AGNI:1521:Oracle12c","java","java");
	 st=con.createStatement();
	 rs=st.executeQuery("select * from emp");	

	 resultsetmetadata = rs.getMetaData();
	 
	 int i = resultsetmetadata.getColumnCount();
	 System.out.println("Coloumn Count:"+" "+i);
	 String col1 = resultsetmetadata.getColumnName(1);
	 String col2 = resultsetmetadata.getColumnName(2);
	 String col3 = resultsetmetadata.getColumnName(3);
	 System.out.println(col1 + " " +col2 +" " +col3);
	 while(rs.next())
	 {
		 System.out.println(rs.getInt(1) + " " + rs.getString(2)+" "+rs.getInt(3) );
	 }
	 System.out.println("*******************");
	 System.out.println(" Information Related your ResulSet");
	 System.out.println("*******************");
	 System.out.println("First column : " + resultsetmetadata.getColumnClassName(1));
	 System.out.println("second column : " + resultsetmetadata.getColumnClassName(2));
	 System.out.println("Third column : " + resultsetmetadata.getColumnClassName(3));
	 System.out.println(" ********************************* ");
	 System.out.println("First column :" + resultsetmetadata.getColumnDisplaySize(1));
	 System.out.println("Second column :" + resultsetmetadata.getColumnDisplaySize(2));
	 System.out.println("Third column :" + resultsetmetadata.getColumnDisplaySize(3));
	 System.out.println(" ********************************* ");
	 System.out.println("First column :" + resultsetmetadata.getColumnTypeName(1));
	 System.out.println("Second column :" + resultsetmetadata.getColumnTypeName(2));
	 System.out.println("Third column :" + resultsetmetadata.getColumnTypeName(3));
	 System.out.println(" ************************************** ");
	}
	catch(SQLException e)
	{
	  e.printStackTrace();
	}
  }
}


