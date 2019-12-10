package UserMANGER;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.PreparedStatement;

public class Student {

	public void Insert() throws ClassNotFoundException, SQLException {
		MyConnection1 con1=new MyConnection1();
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		int f2=0;
		String regemail="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";  //pattern for user name
		System.out.println("Enter the Email");
		String us=s.next();
		Pattern em=Pattern.compile(regemail);      //checking username pattern
		Matcher m1=em.matcher(us);
		
		if(m1.matches())                       //user name valid or not
		{
			System.out.println("valid email");
			f2=1;
		}
		else
		{
			System.out.println("invalid email");
			f2=0;
			}
		System.out.println("Enter the password");
		String psw=s.next();
		if(f2==1)
		{
		PreparedStatement sql=(PreparedStatement) con1.getConnection().prepareStatement("INSERT INTO `studentt`(`USERNAME`, `PASSWORD`) VALUES (?,?)");
		sql.setString(1,us);
		sql.setString(2,psw);
		sql.executeUpdate();
		
	}}

	

}
