package Crud;

import com.mysql.jdbc.PreparedStatement;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class InsertClass {

	
		// TODO Auto-generated method stub
	
		MyConnection con=new MyConnection();
				

	public void Insert() throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		String firstName = "[A-Z][a-z]*";
		String reva="[0-9]*";
		String dpp="[A-Z][.][a-z]*";
		String yer="^\\d{4}$";
		Scanner s=new Scanner(System.in);
       int f=0,f3=0,f6=0,f5=0;
		System.out.println("Enter the ID");
	    int id=s.nextInt();
		System.out.println("Enter the name");
		String name=s.next();
		Pattern nam=Pattern.compile(firstName);      //checking username pattern
		Matcher m2=nam.matcher(name);
		
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
		String reg=s.next();
		Pattern idm=Pattern.compile(reva);      //checking username pattern
		Matcher m3=idm.matcher(reg);
		
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
		String dep=s.next();
		Pattern de=Pattern.compile(dpp);      //checking username pattern
		Matcher m6=de.matcher(dep);
		
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
		String year=s.next();
		Pattern yr=Pattern.compile(yer);      //checking username pattern
		Matcher m5=yr.matcher(year);
		
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
		String add=s.next();
		if(f==1 && f3==1 && f5==1 && f6==1)
		{
	//String sql = "INSERT INTO course(NAME,REG_NO, DEPARTMENT, YEAR, ADDRESS)"+"VALUES('"+name+"','"+reg+"','"+dep+"','"+year+"','"+add+"');";
	PreparedStatement sql=(PreparedStatement) con.getConnection().prepareStatement("insert into student(ID,NAME,REG_NO, DEPARTMENT, YEAR, ADDRESS) VALUES (?,?,?,?,?,?)");
	sql.setInt(1,id);
	sql.setString(2,name);
	sql.setString(3,reg);
	sql.setString(4,dep);
	sql.setString(5,year);
	sql.setString(6,add);
	sql.executeUpdate();
		
	}
		else
		{
			System.out.println("Register not success");
		}
}
	
}
