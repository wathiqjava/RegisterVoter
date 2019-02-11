package com.Regester.swing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class DBconnection {
	

	Connection conn ;  
    public static  Connection connect()   {  
        
        try {  
        	Class.forName("org.sqlite.JDBC");

          // create a connection to the database  
          Connection    conn = DriverManager.getConnection("jdbc:sqlite:D:/JAVA/RegestrationDb.db");
          
          // for windows users    =>    DriverManager.getConnection("jdbc:sqlite:D:\\db\\my-db.sqlite").
          
			  JOptionPane.showMessageDialog(null,"Connection to SQLite has been established.");

              return conn;
        } catch (Exception e) { 
			  JOptionPane.showMessageDialog(null,e.getMessage());

            System.out.println();
            return null;
        }  
    }  
}
