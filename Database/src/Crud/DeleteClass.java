package Crud;

import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class DeleteClass {

	MyConnection con=new MyConnection();
	public void Delete() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		  Scanner s=new Scanner(System.in);
		  System.out.println("Enter the id for deleting");
		  int idd=s.nextInt();
		  String query = "DELETE FROM `student` WHERE ID=?";
	      PreparedStatement Stmt =  (PreparedStatement) con.getConnection().prepareStatement(query);
	      Stmt.setInt(1,idd);
	      
		  Stmt.executeUpdate(); 
		  System.out.println("Delete success");

		
	}

}
