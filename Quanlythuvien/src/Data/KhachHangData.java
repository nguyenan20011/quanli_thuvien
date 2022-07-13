/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.AdminData.ps;
import Object.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaara
 */
public class KhachHangData {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public KhachHang dangNhap(String taiKhoan, String pass) {
        KhachHang kh = null;
        try{
            Connection conn = ConnectDB.getConnect();
             
            ps = conn.prepareStatement("SELECT * FROM Ban_Doc where Ma_Ban_Doc = ? and Password=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                kh = new KhachHang();
                kh.setMaBandoc(rs.getString("Ma_Ban_Doc"));
                kh.setPass(rs.getString("Password"));
                kh.setBirth(rs.getDate("Ngay_sinh"));
                kh.setName(rs.getString("Ten_Ban_Doc"));
                kh.setDiaChi(rs.getString("Dia_chi"));
                kh.setPhone(rs.getString("Phone"));
            }
        }
        catch(Exception e) {
            return kh = null;
        }
        return kh;
    }
    
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = ConnectDB.getConnect().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
     public static void InsertKhachHang(KhachHang kh) {
        String sql = "insert into Ban_Doc values(?,?,?,?,?,?)";
        try {
            ps = ConnectDB.getConnect().prepareStatement(sql);
            ps.setString(1, kh.getMaBandoc());
            ps.setString(2, kh.getPass());
            ps.setString(3, kh.getName());
            ps.setDate(4, kh.getBirth());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getPhone());
           
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm bạn đọc thành công!" , "Thông báo", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Bạn đọc không được thêm" , "Thông báo", 2);
        }
    }
    
    public boolean UpdateKhachHang(KhachHang kh) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("UPDATE Ban_Doc SET Password = ?, Ten_Ban_Doc = ?,"
                    + "Ngay_sinh = ?, Dia_chi = ?, Phone = ? where Ma_Ban_Doc = ?");
            ps.setString(6, kh.getMaBandoc());
            ps.setString(1, kh.getPass());
            ps.setString(2, kh.getName());
            ps.setDate(3, kh.getBirth());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getPhone());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteKhachHang(String maKH) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("DELETE FROM Ban_Doc WHERE Ma_Ban_Doc = ?");
            ps.setString(1, maKH);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
    
}
