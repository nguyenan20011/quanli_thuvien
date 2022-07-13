 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gaara
 */
public class ConnectDB {
    private  static Connection con;
    
    
    public static Connection getConnect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-TH47IC1N;databaseName=qltv;Username=sa;Password=123");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            //con = null ;  
        }
        return con;
    }
    public static String testConnect() {
        try{
            con = ConnectDB.getConnect();
            return "Kết nối thành công";
        }
        catch(Exception e) {
            return "Kết nối thất bại";
        }
    } 
}
