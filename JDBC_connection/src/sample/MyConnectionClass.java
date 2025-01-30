package sample;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.*;

import org.slf4j.Logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyConnectionClass {
	
	public Connection coonObj() {
		Connection con = null;
try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			String url = "jdbc:mysql://localhost:3306/sakila";
			String userName = "root";
			String password = "root";
			
			 con = DriverManager.getConnection(url, userName, password);
			
			
		}catch(Exception e) {
			System.out.println("Exception-->"+e);
		}
		return con;
		
	}
	
	
	
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
			
			String updateQuery = "UPDATE `sakila`.`city` SET `city` = 'Nagpur' WHERE (`city_id` = '617');\r\n"
					+ "";
			statement.executeUpdate(updateQuery);
			System.out.println("Data updated successfully");
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public void retriveData() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			String url = "jdbc:mysql://localhost:3306/sakila";
			String userName = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement statement = con.createStatement();
			
			String retriveQuery = "select * from city where city_id = 94";
			
			ResultSet rs =  statement.executeQuery(retriveQuery);
			rs.next();
			System.out.println(".....");
			System.out.println(rs.getString("city"));
			System.out.println(rs.getString("country_id"));
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void retriveData1() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			String url = "jdbc:mysql://localhost:3306/sakila";
			String userName = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement statement = con.createStatement();
			
			String retriveQuery = "select * from city";
			
			ResultSet rs =  statement.executeQuery(retriveQuery);
			
			while(rs.next()) {
				System.out.println("city="+rs.getString("city") +"city_id="+rs.getString("city_id"));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletData( ) {
		
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
			String deleteQuery = "delete from city where city_id ="+ cityId + "  ";
			statement.executeUpdate(deleteQuery);
			System.out.println("Data deleted successfully");
			con.close();
			
			
		}catch(Exception e) {
			System.out.println("Exception-->"+e);
		}
		
	}
	
public void insertData1() {
		
		try {
			
			
			Statement statement = coonObj().createStatement();
			System.out.println("coonObj()"+coonObj());
			int cityId = 618;
			String insertQuery = "INSERT INTO `sakila`.`city` (`city_id`, `city`, `country_id`, `last_update`) VALUES (" +cityId+", 'Kalyan', '94', '2025-01-23 14:46:17'); ";
			statement.executeUpdate(insertQuery);
			System.out.println("Data inserted successfully");
			//coonObj().close();
			
			
		}catch(Exception e) {
			System.out.println("Exception-->"+e);
		}
	}

public void loggerMethod() {
	log.info("hello....");
	System.out.println("hi..");
}

	public static void main(String[] args) {
		MyConnectionClass m = new MyConnectionClass();
		//m.insertData();
		//m.updateData();
		//m.retriveData();
		//m.retriveData1();
		//m.deletData();
		m.loggerMethod();
		
		
		
		
		
	}

}
