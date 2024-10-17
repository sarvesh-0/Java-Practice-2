package day2_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class EmployeeMgmt extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4;
 JTextField t1,t2,t3;
 JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
 JTable jt1;
 Connection con=null;
 PreparedStatement ps1=null;
 Statement stmt1=null;
 ResultSet rs1=null;
 int flag=0; // flag is created for insert button
 public EmployeeMgmt() throws ClassNotFoundException, SQLException 
 {
        Class.forName("oracle.jdbc.driver.OracleDriver");  
		con=DriverManager.getConnection("jdbc:oracle:thin:@AGNI:1521:oracle12c","java","java"); 
		stmt1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs1=stmt1.executeQuery("select eid,ename,esal from emp");
		setSize(600,500);
	    setLayout(null);
	    
	    l1= new JLabel("Employee Management Information");
	    l1.setBounds(150,20,250,35);
	    l1.setVisible(true);
	    add(l1);

	    l2= new JLabel("Employee Id");
	    l2.setBounds(50,80,150,30);
	    l2.setVisible(true);
	    add(l2);
	    
	    
	    t1= new JTextField(20);
	    t1.setBounds(180,80,150,30);
	    t1.setVisible(true);
	    add(t1);
	    
	    l3= new JLabel("Employee Name");
	    l3.setBounds(50,120,150,30);
	    l3.setVisible(true);
	    add(l3);
	    
	    t2= new JTextField(20);
	    t2.setBounds(180,120,150,30);
	    t2.setVisible(true);
	    add(t2);
	    
	    l4= new JLabel("Employee Salary");
	    l4.setBounds(50,160,150,30);
	    l4.setVisible(true);
	    add(l4);
	    
	    t3= new JTextField(20);
	    t3.setBounds(180,160,150,30);
	    t3.setVisible(true);
	    add(t3);
	    
	    b1= new JButton("First");
	    b1.setBounds(50,210,75,30);
	    b1.addActionListener(this);
	    b1.setVisible(true);
	    add(b1);
	    
	    b2= new JButton("Next");
	    b2.setBounds(135,210,75,30);
	    b2.addActionListener(this);
	    b2.setVisible(true);
	    add(b2);
	    
	    b3= new JButton("Previous");
	    b3.setBounds(225,210,95,30);
	    b3.addActionListener(this);
	    b3.setVisible(true);
	    add(b3);
	    
	    b4= new JButton("Last");
	    b4.setBounds(330,210,75,30);
	    b4.addActionListener(this);
	    b4.setVisible(true);
	    add(b4);
	    //////////////////////////////////////////////////////////////////////////////////////
	    b5= new JButton("Add Employee");
	    b5.setBounds(50,255,120,30);
	    b5.addActionListener(this);
	    b5.setVisible(true);
	    add(b5);
	    
	    b6= new JButton("Insert");
	    b6.setBounds(195,255,75,30);
	    b6.addActionListener(this);
	    b6.setEnabled(false);
	    b6.setVisible(true);
	    add(b6);
	    
	    b7= new JButton("Update");
	    b7.setBounds(285,255,95,30);
	    b7.addActionListener(this);
	    
	    b7.setVisible(true);
	    add(b7);
	    
	    b8= new JButton("Delete");
	    b8.setBounds(390,255,75,30);
	    b8.addActionListener(this);
	    b8.setVisible(true);
	    add(b8);
	    ///////////////////////////////////////////////////////////////
	    b9= new JButton("Abs-nth-Rec");
	    b9.setBounds(50,300,120,30);
	    b9.addActionListener(this);
	    b9.setVisible(true);
	    add(b9);
	    
	    b10= new JButton("Relative-nth-Rec");
	    b10.setBounds(185,300,130,30);
	    b10.addActionListener(this);
	    b10.setVisible(true);
	    add(b10);
	    
	    b11= new JButton("Display All");
	    b11.setBounds(325,300,95,30);
	    b11.addActionListener(this);
	    b11.setVisible(true);
	    add(b11);
	    
	    b12= new JButton("Exit");
	    b12.setBounds(440,300,75,30);
	    b12.addActionListener(this);
	    b12.setVisible(true);
	    add(b12);
	    setVisible(true);
	    
  }//end constructor
 @Override
 public void actionPerformed(ActionEvent ae) 
 {
	 
	 if(ae.getSource()==b1)
	 {
	   try 
	   {
		 rs1.first();
		 t1.setText(""+rs1.getInt(1));
		 t2.setText(""+rs1.getString(2));
		 t3.setText(""+rs1.getInt(3));
	   }
	   catch(SQLException e) 
	   {
		e.printStackTrace();
	   }
	 }
	 if(ae.getSource()==b2)
	 {
		 try 
		   {
			 rs1.next();
			 t1.setText(""+rs1.getInt(1));
			 t2.setText(""+rs1.getString(2));
			 t3.setText(""+rs1.getInt(3));
		   }
		   catch(SQLException e) 
		   {
			e.printStackTrace();
		   } 
	 }
	 if(ae.getSource()==b3)
	 {
		 try 
		   {
			 rs1.previous();
			 t1.setText(""+rs1.getInt(1));
			 t2.setText(""+rs1.getString(2));
			 t3.setText(""+rs1.getInt(3));
		   }
		   catch(SQLException e) 
		   {
			e.printStackTrace();
		   }
	 }
	 if(ae.getSource()==b4)
	 {
		 try 
		   {
			 rs1.last();
			 t1.setText(""+rs1.getInt(1));
			 t2.setText(""+rs1.getString(2));
			 t3.setText(""+rs1.getInt(3));
		   }
		   catch(SQLException e) 
		   {
			e.printStackTrace();
		   }
	 }
	 //////////////////////////////////////////////////////////////////
	 if(ae.getSource()==b5)
	 {
		 flag=1;
		 b6.setEnabled(true);
		 b5.setEnabled(false);
		 t1.setText("");
		 t2.setText("");
		 t3.setText("");
	 }
	 if(ae.getSource()==b6)
	 {
		 if(flag==1)
		 {
		 try 
		   {
			 rs1.last();
			 int eid=Integer.parseInt(t1.getText());
			 String ename=t2.getText();
			 int esal=Integer.parseInt(t3.getText());
			 //add record
			 rs1.moveToInsertRow();
			 rs1.updateInt(1,eid);
			 rs1.updateString(2,ename);
			 rs1.updateInt(3,esal);
			 rs1.insertRow();
			 JOptionPane.showMessageDialog(this,"Record inserted successfully");  
		   }
		   catch(SQLException e) 
		   {
			e.printStackTrace();
		   }
		 }
	    flag=0;
	    b5.setEnabled(true);
	    b6.setEnabled(false);
	 }
	 if(ae.getSource()==b7)
	 {
		 
		 try 
		   {
			 int eid=Integer.parseInt(t1.getText());
			 String ename=t2.getText();
			 int esal=Integer.parseInt(t3.getText());
			 //update record
			 rs1.updateInt(1,eid);
			 rs1.updateString(2,ename);
			 rs1.updateInt(3,esal);
			 rs1.updateRow();
			 JOptionPane.showMessageDialog(this,"Record updated successfully");  
		   }
		   catch(SQLException e) 
		   {
			e.printStackTrace();
		   }
	  }
	 if(ae.getSource()==b8)
	 {
		 try 
		   {
			 rs1.deleteRow();
			 JOptionPane.showMessageDialog(this,"Record Deleted successfully");  
		   }
		   catch(SQLException e) 
		   {
			e.printStackTrace();
		   }
	  }
	/////////////////////////////////////////////////////////////////////////
	 if(ae.getSource()==b9)
	 {
		 int a= Integer.parseInt(JOptionPane.showInputDialog("Enter your abs record number:"));
	     try 
	     {
		  rs1.absolute(a);
		  t1.setText(""+rs1.getInt(1));
		  t2.setText(""+rs1.getString(2));
		  t3.setText(""+rs1.getInt(3));
	     }
	     catch (SQLException e) 
	     {
			e.printStackTrace();
		 }
	 }
	 if(ae.getSource()==b10)
	 {
		 int a= Integer.parseInt(JOptionPane.showInputDialog("Enter your relative record number:"));
	     try 
	     {
		  rs1.relative(a);
		  t1.setText(""+rs1.getInt(1));
		  t2.setText(""+rs1.getString(2));
		  t3.setText(""+rs1.getInt(3));
	     }
	     catch (SQLException e) 
	     {
			e.printStackTrace();
		 }
	 }
	 if(ae.getSource()==b11)
	 {
		
	 }
	 if(ae.getSource()==b12)
	 {
		 System.exit(0);
	 }
	 
 } // end ActionPerformed
 
 public static void main(String[] args) throws ClassNotFoundException, SQLException 
 {
   EmployeeMgmt em= new EmployeeMgmt();
 }// end main
}// end class
