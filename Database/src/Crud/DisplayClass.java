package Crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DisplayClass {

	MyConnection con=new MyConnection();

	public void Display() throws SQLException, ClassNotFoundException {
		
		// TODO Auto-generated method stub
		Statement st= (Statement) con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\n"+rs.getString(2)+"\n"+rs.getString(3)+"\n"+rs.getString(4)+"\n"+rs.getString(5)+"\n");
		}
		
		
	}

	
}
