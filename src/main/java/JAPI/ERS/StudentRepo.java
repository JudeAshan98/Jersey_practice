package JAPI.ERS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;


public class StudentRepo {

	
	Connection connection = null;
	 
//	List <Students> student;

	public StudentRepo() {
		String url = "jdbc:mysql://localhost:3306/paf";
//		student = new ArrayList<Students>();
		String username = "root";
		String pw ="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,pw);
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List <Students> GetAllstudents (){
		
		List<Students> student = new ArrayList<Students>();
		String sql = "Select * from student";
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet Rs = stmt.executeQuery(sql);
			while(Rs.next())
			{
				Students s1 = new Students();
				s1.setId(Rs.getInt(1));
				s1.setName(Rs.getString(2));
				s1.setAge(Rs.getInt(3));
				s1.setCity(Rs.getString(4));
				
				student.add(s1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	public Students getStudents(int id) {
		
		String sql = "Select * from student where id = " + id;
		Students s1 = new Students();
		try {
			Statement stmt = connection.createStatement();
			ResultSet Rs = stmt.executeQuery(sql);
			if(Rs.next())
			{
				s1.setId(Rs.getInt(1));
				s1.setName(Rs.getString(2));
				s1.setAge(Rs.getInt(3));
				s1.setCity(Rs.getString(4));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s1;
	}
	
	
	public void createStd(Students s1) {
		
		String sql = "Insert into student (name , age , city) values (?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

//		stmt.setString(1, s1.getName());
			stmt.setString(1, s1.getName());
			stmt.setInt(2, s1.getAge());
			stmt.setString(3, s1.getCity());
			
			stmt.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	

	public void updateStd(Students s1) {
		
		String sql = "update student set name = ? , age = ? , city = ? where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			
			stmt.setString(1, s1.getName());
			stmt.setInt(2, s1.getAge());
			stmt.setString(3, s1.getCity());
			stmt.setInt(4,1);
			
			stmt.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public void DeleteStudents(int id) {
			
			String sql = "delete from student where id = ?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				
					stmt.setInt(1,id);				
					stmt.executeUpdate();
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			return s1;
		}
	
}
