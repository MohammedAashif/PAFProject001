package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Advice {
	
	private Connection connect()
	{
	Connection con = null;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con =
	DriverManager.getConnection(
	"jdbc:mysql://127.0.0.1:3306/test", "root", "");
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	
	return con;
	}
	public String readAdvise()
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{
	return "Error while connecting to the database for reading.";
	}
	
	// Prepare the html table to be displayed
	
	output = "<table border='1'><tr>"
			+ "<th>Id</th> <th>Adviser Name</th><th>Item Price</th>"
	+ "<th>Item Description</th>"
	+ "<th>Update</th><th>Remove</th></tr>";
	
	String query = "select * from advice";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	
	// iterate through the rows in the result set
	
	while (rs.next())
	{
	String Id = Integer.toString(rs.getInt("Id"));
	String AdviserName = rs.getString("AdviserName");
	String ResearchGroupId = rs.getString("ResearchGroupId");
	String ResearchType = rs.getString("ResearchType");
	String AdvisingType = rs.getString("AdvicingType");
	String AdviserCurrentLevel = rs.getString("AdviserCurrentLevel");
	
	
	// Add into the html table
	
	output += "<tr> <td>"+ AdviserName + "</td>";
	output += "<td>" + ResearchGroupId + "</td>";
	output += "<td>" + ResearchType + "</td>";
	output += "<td>" + AdvisingType + "</td>";
	output += "<td>" + AdviserCurrentLevel + "</td>";
	
	
	// buttons
	
	output += "<td><input name='btnUpdate' type='button' value='Update'"
	+"class='btnUpdate btn btn-secondary'> data-id='\"+Id +\"'> </td>"
	+ "<td><input name='btnRemove' type='button' value='Remove'" 
	+"class='btnRemove btn btn-danger' data-itemid='\"+Id +\"'></td></tr>";
	
	}
	con.close();
	
	// Complete the html table
	
	output += "</table>";
	
	}
	
	catch (Exception e)
	{
	output = "Error while reading the items.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	
	public String insertItem(String AdviserName, String ResearchGroupId, String ResearchType , String AdvisingType , String AdviserCurrentLevel)
	{
		
	String output = "";
	
	try
	{
	Connection con = connect();
	if (con == null)
	{
	return "Error while connecting to the database for inserting.";
	}
	
	// create a prepared statement
	
	String query = " insert into advice (Id,AdviserName,ResearchGroupId,ResearchType,AdvisingType,AdviserCurrentLevel)"
			+"  values (?, ?, ?, ?, ?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			 
			// binding values
			
			pst.setInt(1, 0);
			pst.setString(2, AdviserName);
			pst.setString(3, ResearchGroupId);
			pst.setString(4, ResearchType);
			pst.setString(5, AdvisingType);
			pst.setString(6, AdviserCurrentLevel);
			
			pst.execute();
			
			con.close();
			
			String newAdvise = readAdvise();
			output = "{\"status\":\"success\", \"data\": \"" +
			newAdvise + "\"}";
}
catch (Exception e)
{
output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}";
System.err.println(e.getMessage());
}
return output;
}
public String deleteItem(String itemID)
{
String output = "";
try
{
Connection con = connect();
if (con == null)
{
return "Error while connecting to the database for deleting.";
}

//create a prepared statement

String query = "delete from items where itemID=?";
PreparedStatement preparedStmt = con.prepareStatement(query);

//binding values

preparedStmt.setInt(1, Integer.parseInt(itemID));

//execute the statement

preparedStmt.execute();
con.close();
String newItems = readAdvise();
output = "{\"status\":\"success\", \"data\": \"" +
newItems + "\"}";

}
catch (Exception e)
{
output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
System.err.println(e.getMessage());
}
return output;
}

}
