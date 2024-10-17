package day2_3;
import java.sql.*;
import java.util.StringTokenizer;
public class DatabaseMetaDataDemo
{
	public static void main(String args[])
	{
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");  
		   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@AGNI:1521:Oracle12c","java","java");

			DatabaseMetaData dbmd=con.getMetaData();
			System.out.println("Driver Name :"+dbmd.getDriverName());
			System.out.println("Database Product:"+dbmd.getDatabaseProductName());
			System.out.println("Database Product Version "+dbmd.getDatabaseProductVersion());
			System.out.println("Driver Version"+dbmd.getDriverVersion());
			System.out.println("User name"+dbmd.getUserName());
			System.out.println("Quote String"+dbmd.getIdentifierQuoteString());
			System.out.println("\n\nSQL KYWORDS" +dbmd.getSQLKeywords());
			System.out.println("\n\nnumeric functions "+dbmd.getNumericFunctions());
			System.out.println("\n\nString functions "+dbmd.getStringFunctions());
			System.out.println("\n\nSystem functions " +dbmd.getSystemFunctions());
			System.out.println("\n\ntime date functions "+dbmd.getTimeDateFunctions());
			System.out.println("\n\nsearchString "+dbmd.getSearchStringEscape());

			System.out.println("SQL KEYWORD SUPPORETD");
		 
			StringTokenizer st=new StringTokenizer(dbmd.getSQLKeywords(),",");
			while(st.hasMoreTokens())
				System.out.println(" "+st.nextToken());
		//views and so forth

			String [] tableTypes={"TABLE"};
			ResultSet allTables=dbmd.getTables(null,null,null,tableTypes);
			while(allTables.next())
			{
				String table_name=allTables.getString("TABLE_NAME");
				System.out.println("Table_NAME"+table_name);
				System.out.println("Indexes");

				/*ResultSet indexList=dbmd.getIndexInfo(null,null,table_name,false,false);
				while(indexList.next())
				{
					System.out.println("INDEX_NAME:"+indexList.next());
					
					//	System.out.println("Column Name:"+indexList.getString("COLUMN_NAME");

				}*/
			}
	}//e of try
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

}
