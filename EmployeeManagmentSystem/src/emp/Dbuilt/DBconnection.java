package emp.Dbuilt;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBconnection {
	
static  Connection con=null;

	static {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeProject","root","root");
			JOptionPane.showMessageDialog(null,"Sucessfully loaded","sucess!",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "Class not found exception"+e.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null,"SQL Exception"+e.getMessage(),"Exception", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		return (con);
	}
	public static void closeConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				
				JOptionPane.showMessageDialog(null,"Error while disconnecting","Exception",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}
}
