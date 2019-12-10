package UserMANGER;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Login {

	public void log() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		MyConnection1 con1=new MyConnection1();
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome ----");
		System.out.println("Enter user name");
		String uname=s.next();
		System.out.println("Enter password");
		String pass=s.next();
		Statement st= (Statement) con1.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from studentt");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\n"+rs.getString(2)+"\n"+rs.getString(3));}
		

	}

}
