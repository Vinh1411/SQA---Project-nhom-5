/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Vinh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DAO {
    public static Connection con;
    
    public DAO(){
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/hethongtinhthue?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.cj.jdbc.Driver";
 
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "root", "vinhcoi123");
            }catch(ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
