package emp.dao;

import emp.Dbuilt.DBconnection;
import java.sql.*;
import java.util.ArrayList;
import emp.pojo.Employee;

public class EmpDao {
	
public static boolean addEmployee(Employee e)throws Exception {
	Connection con=DBconnection.getConnection();
	PreparedStatement ps=con.prepareStatement("insert into EmployeeTable values(?,?,?)");
	
	ps.setInt(1, e.getId());
	ps.setString(2, e.getName());
	ps.setDouble(3, e.getSalary());
	
	int count=ps.executeUpdate();
	if(count==0) {
		return false;
	}
	else {
		return true;
	}
}

public static ArrayList<Employee> getAllEmployee()throws Exception {
	
	Connection con=DBconnection.getConnection();
	ArrayList<Employee> empList = new ArrayList<>();
	
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select empid,empname,empsalary from EmployeeTable");
	
	while (rs.next()) {
		Employee e1 = new Employee();
		
		e1.setId(rs.getInt("empId"));
		e1.setName(rs.getString("empName"));
		e1.setSalary(rs.getDouble("empSalary"));
		
		empList.add(e1);
	}
	return empList;
}

public static boolean updateEmployee(Employee e1)throws Exception {
	
	Connection con=DBconnection.getConnection();
	PreparedStatement ps=con.prepareStatement("update EmployeeTable set empName=?,empSalary=? where empId=?");
	
	ps.setString(1,e1.getName());
	ps.setDouble(2, e1.getSalary());
	ps.setInt(3, e1.getId());
	
	int c=ps.executeUpdate();
	return c!= 0;
}
public static boolean deleteEmp(int eNumber)throws SQLException {
	
	Connection con=DBconnection.getConnection();
	PreparedStatement ps=con.prepareStatement("Delete from EmployeeTable where empid=?");
	
	ps.setInt(1,eNumber);
	int c=ps.executeUpdate();
		
	return c!=0;
	
}
public static Employee searchEmployee(int eNumber)throws SQLException,NullPointerException {
	
	Employee e=null;
	Connection con=DBconnection.getConnection();
	Statement st=con.createStatement();
	
	ResultSet rs=st.executeQuery("select empName,empSalary,empid from EmployeeTable where empId="+eNumber);
	
	while (rs.next()) {
		
		e = new Employee();
		e.setName(rs.getString("empName"));
		e.setSalary(rs.getDouble("empSalary"));
	}
	
	return e;
	}
}
