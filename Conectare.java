package ProduseSQL;

import java.sql.*;
import javax.swing.*;

public class Conectare {
	Connection con;
	
	public static Connection conect() {
    	try {
    		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.82.193:3306/arobs","host","arobs2019sql");
    		if(con != null) {
    		JOptionPane.showMessageDialog(null, "Te-ai conectat la baza de date din SQL!");
    		}return con;
    	} catch(Exception ex) {
    		JOptionPane.showMessageDialog(null, "Nu te-ai conectat la baza de date din SQL!");
    		return null;
    	}
    } 

}
