package sample;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyClass {
	
public void insertData() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			String url = "jdbc:mysql://localhost:3306/sakila";
			String userName = "root";
			String password = "root";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement statement = con.createStatement();
			
			int cityId = 618;
			String insertQuery = "INSERT INTO `sakila`.`city` (`city_id`, `city`, `country_id`, `last_update`) VALUES (" +cityId+", 'Kalyan', '94', '2025-01-23 14:46:17'); ";
			statement.executeUpdate(insertQuery);
			System.out.println("Data inserted successfully");
			con.close();
			
			
		}catch(Exception e) {
			System.out.println("Exception-->"+e);
		}
	}

public void updateData() {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Driver myDriver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(myDriver);
		String url = "jdbc:mysql://localhost:3306/sakila";
		String userName = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement statement = con.createStatement();
		String updateQuery = "";
		statement.executeUpdate(updateQuery);
		con.close();
		
	}catch(Exception e) {
		System.out.println(e);
	}
	
}

public void deleteData() {
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Driver myDriver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(myDriver);
		String url = "jdbc:mysql://localhost:3306/sakila";
		String userName = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement statement = con.createStatement();
		String deleteQuery = "";
		statement.executeUpdate(deleteQuery);
		con.close();
		
		
		
	}catch(Exception e) {
		System.out.println(e);
	}
	
}

public void retriveData() {
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Driver myDriver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(myDriver);
		String url = "jdbc:mysql://localhost:3306/sakila";
		String userName = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement statement = con.createStatement();
		
		String retriveQuery = "Select * from city  ";
		ResultSet rs = statement.executeQuery(retriveQuery);
		//rs.next();
		//System.out.println("CityName="+rs.getString("city"));
		//rs.next();
		//System.out.println("CityName="+rs.getString("city"));
		//rs.next();
		//System.out.println("CityName="+rs.getString("city"));
		
		String cityName = "";
		int cityId = 0;
		
		while(rs.next()) {
			cityName = rs.getString("city");
			cityId = rs.getInt("city_id");
			System.out.println("CityName="+cityName+" "+ "cityId="+cityId);
		}
		
		
		
		
	}catch(Exception e) {
		System.out.println(e);
	}
	
}

	public static void main(String[] args) {
		MyClass m = new MyClass();
		//m.insertData();
		m.retriveData();

	}

}
