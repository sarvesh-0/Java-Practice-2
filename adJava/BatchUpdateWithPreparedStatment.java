package day2_1;
import java.sql.*;
import java.io.*;
public class BatchUpdateWithPreparedStatment 
{
 public static void main(String[] args) 
 {
  try
   {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@AGNI:1521:Oracle12c","java","java");
    // create student table 
	PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?,?)");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
	while(true)
	{  
			System.out.print("Enter the Student Id:");  
			int sid=Integer.parseInt(br.readLine());  
			System.out.print("Enter the Student Name:");  
			String sname=br.readLine();  
			System.out.print("Enter the Student Age:");  
			int sage=Integer.parseInt(br.readLine()); 
			System.out.println("Enter the Student city:");  
			String scity=br.readLine();  
			ps.setInt(1,sid);  
			ps.setString(2,sname);  
			ps.setInt(3,sage); 
			ps.setString(4,scity);
			ps.addBatch();  
			System.out.print("do wantto add more records?y/n: ");  
			String ans=br.readLine();  
			if(ans.equals("n")){  
			break;  
			}  
		}
			int c[]=ps.executeBatch();  
			System.out.println("Batche of "+c.length+" Records");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
