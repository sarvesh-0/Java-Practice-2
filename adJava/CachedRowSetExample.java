package day2_3;
import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.*;
//import com.sun.rowset.*;

public class CachedRowSetExample
{ 
public static void main(String[] args)throws Exception
{ 
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		
		CachedRowSet crs=RowSetProvider.newFactory().createCachedRowSet();
		
		//CachedRowSet crs= new CachedRowSetImpl();
		//for IMPL   
		//PROJECT->PROPERTIES->JAVA COMPILER->ERROR & WARNINING->
		// deprecated & restricted api->forbidden rule=> change to ignore or warning 
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@AGNI:1521:Oracle12c","java","java"); 
		
		Statement st=con.createStatement(); 
		
		ResultSet rs=st.executeQuery("select *from emp"); 
		
		crs.populate(rs);//populates the data into RowSet from ResultSet 
		rs.close(); 
		st.close(); 
		con.close();//connection is closed 
		
		while(crs.next()) 
		{ 
		  System.out.print(crs.getInt(1)+"\t"); 
		  System.out.println(crs.getString(2)+"\t"); 
		  System.out.println(crs.getInt(3)+"\t"); 
		} 

 } 
}