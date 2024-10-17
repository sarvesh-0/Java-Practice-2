package day2_3;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;


// Connected Architecture
public class JDBCRowSetDemo 
{
 public static void main(String[] args) throws ClassNotFoundException, SQLException 
 {

	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 String url="jdbc:oracle:thin:@AGNI:1521:Oracle12c";
	 
	 JdbcRowSet rowset=RowSetProvider.newFactory().createJdbcRowSet();
	 rowset.setUrl(url);
	 rowset.setUsername("java");
	 rowset.setPassword("java");
	 rowset.setCommand("select * from emp");
	 rowset.execute();
	 
	 while(rowset.next())
	 {
		System.out.println(" "+rowset.getInt(1)+" "+rowset.getString(2)+rowset.getInt(3)); 
	 }
  }
}
