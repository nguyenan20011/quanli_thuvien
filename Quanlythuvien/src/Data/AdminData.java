/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.KhachHangData.ps;
import Object.Admin;
import Object.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gaara
 */
public class AdminData {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    
    public Admin dangNhap(String taiKhoan, String pass) {
        Admin ad = null;
        try{
            Connection conn = ConnectDB.getConnect();
             
            ps = conn.prepareStatement("SELECT * FROM QUAN_TRI where Ma_Admin = ? and Password=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                ad = new Admin();
               // kh.setMaKH(rs.getString("Ma_Khach_hang"));
               // kh.setPass(rs.getString("Password"));
                
            }
        }
        catch(SQLException e) {
             System.out.println(e.getMessage());
            return null;
        }
        return ad;
    }
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = ConnectDB.getConnect().prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    public boolean UpdateAdmin(Admin ad) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("UPDATE QUAN_TRI SET Password = ? where Ma_Admin = ?");
            ps.setString(2, ad.getMaAdmin());
            ps.setString(1, ad.getPassword());
            return ps.executeUpdate() >0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean DeleteAdmin(String maAd) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("DELETE FROM QUAN_TRI WHERE Ma_Admin = ?");
            ps.setString(1, maAd);
            return ps.executeUpdate() >0;
        } catch(SQLException e) {
            return false;
        }
    }
}
