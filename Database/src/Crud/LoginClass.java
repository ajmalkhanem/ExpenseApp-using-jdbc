package Crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class LoginClass {

	MyConnection con=new MyConnection();
	public void Login() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome ----");
		System.out.println("Enter user name");
		String uname=s.next();
		System.out.println("Enter password");
		String pass=s.next();
		 String query2 = "SELECT * FROM `student` WHERE `NAME` =? AND `REG_NO` =?";
	        
	        try {
	        	PreparedStatement pt =  (PreparedStatement) con.getConnection().prepareStatement(query2);
	            
	            pt.setString(1, uname);
	            pt.setString(2, pass);
	            
	            ResultSet rs  = pt.executeQuery();
	            if(rs.next())
	            {
	            	System.out.println("Welcome "+uname );  
	                  
	                    
	                    
	            }
	            else{
	                    System.out.println("Incorrect Username Or Password" );
	                }
	            
	        } catch (SQLException ex) {
	            System.out.println( ex);
	        }

	            
		
		
	}

}
