package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionManager {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//5 steps to create connection
		//1.load and register driver
		//2.create connection
		//3.create statement
		//4.excecute the query
		//5.close the connection

		
	         //method	
		Class.forName("com.mysql.jdbc.Driver"); // load driver
		
	
		Connection con=null; // create connection object
		
		                //class.method            //("API:database://servername:portnumber/databasename","username","psw");
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","");  // create connection
		
		// checking connection
		if(con!=null)
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Not Success");
		}
		
		con.close(); // closing connection
	}

}
