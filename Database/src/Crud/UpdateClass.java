package Crud;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.PreparedStatement;

public class UpdateClass {


	
	MyConnection con=new MyConnection();
	public void Update() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		 System.out.println("Enter the id for update");
		   int idd1=s.nextInt();
		  /* System.out.println("Enter the ID");
		    int id2=s.nextInt();
			System.out.println("Enter the name");
			String name2=s.next();
			System.out.println("Enter the reg number");
			String reg2=s.next();
			System.out.println("Enter the Department");
			String dep2=s.next();
			System.out.println("Enter the year");
			String year2=s.next();
			System.out.println("Enter the Address");
			String add2=s.next();*/
		   String firstName = "[A-Z][a-z]*";
			String reva="[0-9]*";
			String dpp="[A-Z][.][a-z]*";
			String yer="^\\d{4}$";
			//Scanner s=new Scanner(System.in);
	       int f=0,f3=0,f6=0,f5=0;
			System.out.println("Enter the ID");
		    int id2=s.nextInt();
			System.out.println("Enter the name");
			String name2=s.next();
			Pattern nam=Pattern.compile(firstName);      //checking username pattern
			Matcher m2=nam.matcher(name2);
			
			if(m2.matches())                       //user name valid or not
			{
				System.out.println("valid name");
				f=1;
			}
			else
			{
				System.out.println("invalid name");
				f=0;
			}
			System.out.println("Enter the reg number");
			String reg2=s.next();
			Pattern idm=Pattern.compile(reva);      //checking username pattern
			Matcher m3=idm.matcher(reg2);
			
			if(m3.matches())                       //user name valid or not
			{
				System.out.println("valid regid");
				f3=1;
			}
			else
			{
				System.out.println("invalid regid");
				f3=0;
				
			}
			
			System.out.println("Enter the Department");
			String dep2=s.next();
			Pattern de=Pattern.compile(dpp);      //checking username pattern
			Matcher m6=de.matcher(dep2);
			
			if(m6.matches())                       //user name valid or not
			{
				System.out.println("valid dep");
				f6=1;
			}
			else
			{
				System.out.println("invalid dep");
				f6=0;
			}
			System.out.println("Enter the year");
			String year2=s.next();
			Pattern yr=Pattern.compile(yer);      //checking username pattern
			Matcher m5=yr.matcher(year2);
			
			if(m5.matches())                       //user name valid or not
			{
				System.out.println("valid year");
				f5=1;
			}
			else
			{
				System.out.println("invalid year");
				f5=0;
			}
			System.out.println("Enter the Address");
			String add2=s.next();
			if(f==1 && f3==1 && f5==1 && f6==1)
			{
			  String query1 = "update student set ID = ?, NAME = ?, REG_NO = ?, DEPARTMENT = ?, YEAR = ?, ADDRESS = ? where ID = ?";
		      PreparedStatement preparedStmt =  (PreparedStatement) con.getConnection().prepareStatement(query1);
		      preparedStmt.setInt   (1, id2);
		      preparedStmt.setString(2, name2);
		      preparedStmt.setString(3, reg2);
		      preparedStmt.setString(4, dep2);
		      preparedStmt.setString(5, year2);
		      preparedStmt.setString(6, add2);
		      preparedStmt.setInt   (7, idd1);
		      preparedStmt.executeUpdate();
		  System.out.println("update success");
			}else
			{
				System.out.println("Update not success");
			}
		
	}

}
