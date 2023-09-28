package com.StudentMs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddStudents {
	public static void main( String[] args ) throws Exception
    {

    	//load and register driver
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//create the object to get Connection
    	//url to db,username,password
    	String url="jdbc:mysql://localhost:3306/StudentMs";
    	String username="root";
    	String password="Poonu@15";
    	Connection ps=DriverManager.getConnection(url,username,password);
    	
    	int SNo=4;
    	String SName="Pallavi";
    	String SClass="M.Sc(IT)";
    	int SMarks=75;
    	String query="insert into students values(?,?,?,?)";
    	
    	PreparedStatement pst=ps.prepareStatement(query);
    	pst.setInt(1, SNo);
    	pst.setString(2, SName);
    	pst.setString(3, SClass);
    	pst.setInt(4, SMarks);
    	
    	int count=pst.executeUpdate();
    	System.out.println(count+" row(s) effected");
    }	
}
