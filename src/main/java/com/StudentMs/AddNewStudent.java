package com.StudentMs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddNewStudent {

	public static void main( String[] args ) throws Exception
    {
		//TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
    	//load and register driver
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//create the object to get Connection
    	//url to db,username,password
    	String url="jdbc:mysql://localhost:3306/StudentMs";
    	String username="root";
    	String password="Poonu@15";
    	Connection ps=DriverManager.getConnection(url,username,password);
    	
    	System.out.println("/t/t/t******************Add Student to DB******************");
    	System.out.println("Enter Student SNo");
    	int SNo=sc.nextInt();
    	System.out.println("Enter Student Name");
    	sc.nextLine();
    	String SName=sc.nextLine();
    	System.out.println("Enter Student Class");
    	sc.nextLine();
    	String SClass=sc.nextLine();
    	System.out.println("Enter Student Marks");
    	int SMarks=sc.nextInt();
    	
    	String query="insert into students values(?,?,?,?)";
    	
    	PreparedStatement pst=ps.prepareStatement(query);
    	pst.setInt(1, SNo);
    	pst.setString(2, SName);
    	pst.setString(3, SClass);
    	pst.setInt(4, SMarks);
    	
    	int count=pst.executeUpdate();
    	System.out.println(count+" row(s) effected");
    	ps.close();
    	sc.close();
    }	
	
}
