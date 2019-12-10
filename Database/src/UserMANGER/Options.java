package UserMANGER;
import java.sql.SQLException;
import java.util.Scanner;

public class Options {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		System.out.println("1.insert\n2.login\n3.exit");
		
		int op=s.nextInt();
		if(op==1)
		{
			System.out.println("1.admin\n2.student");
			System.out.println("enter the option");
			int op1=s.nextInt();
			switch(op1)
			{
			case 1:
				Admin ad=new Admin();
				ad.Insert();
				break;
			case 2:
				Student st=new Student();
				st.Insert();
				break;
			}
		}
		if(op==2)
		{
			Login lg=new Login();
			lg.log();
		}
		
	}

}
