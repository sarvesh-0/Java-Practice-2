package day3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		int bal = 0;
		int ano = 0;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@AGNI:1521:Oracle12c","java","java");
			con.setAutoCommit(false);
			System.out.print("\nEnter your Account Number : ");
			int ano1 = sc.nextInt();
			PreparedStatement ps1 = con.prepareStatement("Select accno, custname, balance from account001 where accno = ?");
			ps1.setInt(1,ano1);
			ResultSet rs=ps1.executeQuery();
			if(rs.next()) {
				bal = rs.getInt(3);
				System.out.println("Account Number  : "+rs.getInt(1));
				System.out.println("Customer Name   : "+rs.getString(2));
				System.out.println("Account Balance : "+bal);
			}
			else {
				System.out.println("Account Not Found !");
			}
			rs.close();
			ps1.close();
			
			
			System.out.print("\nEnter Account Number to Transfer : ");
			ano = sc.nextInt();
			PreparedStatement ps2 = con.prepareStatement("Select accno, custname, balance from account001 where accno = ?");
			ps2.setInt(1,ano);
			rs=ps2.executeQuery();
			if(rs.next()) {
				System.out.println("Account Number  : "+rs.getInt(1));
				System.out.println("Customer Name   : "+rs.getString(2));
				System.out.println("Account Balance : "+rs.getInt(3));
			}
			else {
				System.out.println("Account not found !");
			}
			rs.close();
			
			System.out.print("\nEnter Amount You Want to transfer : ");
			int am = sc.nextInt();
			if(bal < am) {
				System.out.println("Insufficient Balance !");
			}
			else {
				PreparedStatement ps3 = con.prepareStatement("update account001 set balance=balance - ? where accno = ?");
				ps3.setInt(1, am);
				ps3.setInt(2, ano1);
				if(ps3.executeUpdate()>0) {
					System.out.println("\nAmmount "+am+" is Debited !\n");
				}else {
					throw new SecurityException();
				}
				
				PreparedStatement ps4 = con.prepareStatement("update account001 set balance=balance + ? where accno = ?");
				ps4.setInt(1, am);
				ps4.setInt(2, ano);
				if(ps4.executeUpdate()>0) {
					System.out.println("\nTransaction Successful !\n");
				}else {
					throw new SecurityException();
				}
				
				PreparedStatement ps5 = con.prepareStatement("Select accno, custname, balance from account001 where accno in (?,?)");
				ps5.setInt(1,ano);
				ps5.setInt(2,ano1);
				rs = ps5.executeQuery();
				while(rs.next()) {
					System.out.println("Account Number  : "+rs.getInt(1));
					System.out.println("Customer Name   : "+rs.getString(2));
					System.out.println("Account Balance : "+rs.getInt(3));
				}
				con.commit();
				con.close();
				sc.close();
			}
		}
		catch(SecurityException e){
			con.rollback();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
