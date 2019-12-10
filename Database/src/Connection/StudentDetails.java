package Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.StatementImpl;
public class StudentDetails {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

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
		
		Scanner s=new Scanner(System.in);
		System.out.println("1.insert\n2.display\n3.delete\n4.update");
		System.out.println("Enter the option");
		int op=s.nextInt();
		switch(op)
		{
		case 1:
			System.out.println("Enter the ID");
		    int id=s.nextInt();
			System.out.println("Enter the name");
			String name=s.next();
			System.out.println("Enter the reg number");
			String reg=s.next();
			System.out.println("Enter the Department");
			String dep=s.next();
			System.out.println("Enter the year");
			String year=s.next();
			System.out.println("Enter the Address");
			String add=s.next();
		//String sql = "INSERT INTO course(NAME,REG_NO, DEPARTMENT, YEAR, ADDRESS)"+"VALUES('"+name+"','"+reg+"','"+dep+"','"+year+"','"+add+"');";
		PreparedStatement sql=(PreparedStatement) con.prepareStatement("insert into student(ID,NAME,REG_NO, DEPARTMENT, YEAR, ADDRESS) VALUES (?,?,?,?,?,?)");
		sql.setInt(1,id);
		sql.setString(2,name);
		sql.setString(3,reg);
		sql.setString(4,dep);
		sql.setString(5,year);
		sql.setString(6,add);
		sql.executeUpdate();
			break;
		case 2:
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from student");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\n"+rs.getString(2)+"\n"+rs.getString(3)+"\n"+rs.getString(4)+"\n"+rs.getString(5)+"\n");
			}
			
			break;
		case 3:
			  System.out.println("Enter the id for deleting");
			  int idd=s.nextInt();
			  String query = "DELETE FROM `student` WHERE ID=?";
		      PreparedStatement Stmt = (PreparedStatement) con.prepareStatement(query);
		      Stmt.setInt(1,idd);
			  Stmt.executeUpdate();
			  System.out.println("Delete success");
			  break;
		case 4:
			   System.out.println("Enter the id for update");
			   int idd1=s.nextInt();
			   System.out.println("Enter the ID");
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
				String add2=s.next();
				 String query1 = "update student set ID = ?, NAME = ?, REG_NO = ?, DEPARTMENT = ?, YEAR = ?, ADDRESS = ? where ID = ?";
			      PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query1);
			      preparedStmt.setInt   (1, id2);
			      preparedStmt.setString(2, name2);
			      preparedStmt.setString(3, reg2);
			      preparedStmt.setString(4, dep2);
			      preparedStmt.setString(5, year2);
			      preparedStmt.setString(6, add2);
			      preparedStmt.setInt   (7, idd1);
			      preparedStmt.executeUpdate();
			  System.out.println("update success");
			  break;
		}
		
	con.close(); // closing connection

	}

	
	}

	


