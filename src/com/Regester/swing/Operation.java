package com.Regester.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
public class Operation extends Report {
	
	
	private static final ResultSet ResultSet = null;
	Connection conn  = null; //1
	private JComboBox comboBoxName;
	
	public ResultSet  FillJComboPcId() {
		 ResultSet rs=null;
	    try {   //6
	    	
		    String sql = "select PCId from PollingCenter";  
	        PreparedStatement pst  = conn.prepareStatement(sql);  
	         rs = pst.executeQuery();
  
	      
	     
	} catch (SQLException e1) {  
	    System.out.println(e1.getMessage());  
	}
	    return rs;
	}
	//===========================================================================================
	public ResultSet  FillJComboType() {
		 ResultSet rs=null;
	    try {   //6
	    	
		    String sql = "select * from Type_Voter";  
	        PreparedStatement pst  = conn.prepareStatement(sql);  
	         rs = pst.executeQuery();
 
	      
	     
	} catch (SQLException e1) {  
	    System.out.println(e1.getMessage());  
	}
	    return rs;
	}
	//------------------------------------------------------------------------------------------------------
	
	public int Insert(int vid,String name,int age,String email,String type,int pcid,int userid,String date) {
		conn=DBconnection.connect();
		try {
			String sql=    "INSERT INTO Person ([VoterId] ,[Name],[Age],[Email],[IdType_V],[PCId] ,[Id_User],[Creation_Date]) values (?,?,?,?,?,?,?,?)";
			 PreparedStatement pst  = conn.prepareStatement(sql); 
			 pst.setInt(1, vid);
			 pst.setString(2,name);
			 pst.setInt(3,age);
			 pst.setString(4, email);
			 pst.setInt(5,(type.equals("REGULAR")) ? 1 : 2);
			 pst.setInt(6,pcid);
			 pst.setInt(7, userid);
			 pst.setString(8,date);
			 pst.execute();
			 pst.close();
			 
		}catch (SQLException e1) {
			System.out.println(e1.getMessage()); 
			return 0;
		}
		return 1;
	}
	
	//=============================================================================================================================================================
	public int update(int vid,String name,int age,String email,String type,int pcid,int userid,String date,String vote) {
		
		
		try {
			String sql=    "update Person set [Name1]=?,[Age]=?,[Email]=?,[IdType_V1]=?,[PCId]=? ,[Id_User]=?,[Creation_Date]=? ,[Chk_Vote]=?   where VoterId=?";
			 PreparedStatement pst  = conn.prepareStatement(sql);
			 pst.setString(1,name);
			 pst.setInt(2,age);
			 pst.setString(3, email);
			 pst.setInt(4,(type.equals("REGULAR")) ? 1 : 2);
			 pst.setInt(5,pcid);
			 pst.setInt(6, userid);
			 pst.setString(7,date);
			 pst.setInt(8,(vote.equals("voting")) ? 1 : 0);
			 pst.setInt(9, vid);
			 pst.execute();
			 pst.close();
		}catch (SQLException e1) {
			System.out.println(e1.getMessage()); 
			return 0;
		}
		return 1;
	}
		
	public int login(String name,String pass) {
		 int count=0;
		try {
			conn=DBconnection.connect();
			
			String sql=    "select * from Users where Name=? and Password=?";
			 PreparedStatement pst  = conn.prepareStatement(sql); 
			 pst.setString(1, name);
			 pst.setString(2,pass);
			 ResultSet rs = pst.executeQuery();
			
		        while (rs.next()) {  
		        	
		        	count +=1;
		        } 
		        rs.close();
		        pst.close();
		     
		        
		}catch (SQLException e1) {
			System.out.println(e1.getMessage()); 
			return 0;
		}
		
		return count;
	}
	
	public int Insert(String name,String pass,String date) {
	
		try {
			conn=DBconnection.connect();
			
						
			String sql=    "insert into Users (Name,Password,Date_Create) values(?,?,?)";
			 PreparedStatement pst  = conn.prepareStatement(sql); 
			 pst.setString(1, name);
			 pst.setString(2,pass);
			 pst.setString(3,date);
			 pst.execute();
		     pst.close();
				     
		        
		}catch (SQLException e1) {
			System.out.println(e1.getMessage()); 
			return 0;
		}
		
		return 1;
	}

	


public ResultSet get(int vno) {
	 int count=0;
	 ResultSet rs2=null;
	try {
		conn=DBconnection.connect();
		JOptionPane.showMessageDialog(null,vno);
		String sql=    "select * from Person where VoterId=?";
		 PreparedStatement pst  = conn.prepareStatement(sql); 
		 pst.setInt(1, vno);
		 ResultSet rs = pst.executeQuery();
		
	        while (rs.next()) {  
	        	
	        	count +=1;
	        } 
	        
	        rs.close();
	        pst.close();
	        return rs;
	        
	}catch (SQLException e1) {
		JOptionPane.showMessageDialog(null,e1.getMessage()); 
		return  rs2;
	}
	
}

public ResultSet rpt_No_Register() {
	 int count=0;
	 ResultSet rs2=null;
	try {
		conn=DBconnection.connect();
		 String sql=    "select * from Person";
		 PreparedStatement pst  = conn.prepareStatement(sql); 
		 ResultSet rs = pst.executeQuery();
		
	        while (rs.next()) {  
	        	
	        	count +=1;
	        } 
	        
	        rs.close();
	        pst.close();
	        return rs;
	        
	}catch (SQLException e1) {
		JOptionPane.showMessageDialog(null,e1.getMessage()); 
		return  rs2;
	}	
	
	
}

}
