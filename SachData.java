/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Object.Sach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class SachData {
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static ResultSet showTextfield(String sql) {
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    public static void InsertSach(Sach s){
        SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");//Khai bao kieu du lieu date
        String ngayxb = date_format.format(s.getngayxb());
        String sql = "INSERT INTO sach values(?,?,?,?,?,?,?)";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setInt(1, s.getmaSach());
            ps.setString(2, s.gettenSach());
            ps.setString(3, s.gettenTheloai());
            ps.setString(4, s.gettenTacgia());
            ps.setString(5, s.gettenNxb());
            ps.setString(6, ngayxb);
            ps.setInt(7, s.getsluong());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm sách thành công", "Thông báo", 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Sách không được thêm", "Thông báo", 2);
        }
    }
    public boolean UpdateSach(Sach s){
        SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");//Khai bao kieu du lieu date
        String ngayxb = date_format.format(s.getngayxb());
        String sql = "UPDATE sach SET name = ?, type_name = ?, id_author = ?, publish_name = ?, publish_date = ?,amount = ? WHERE id = ?";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setInt(7, s.getmaSach());
            ps.setString(1, s.gettenSach());
            ps.setString(2, s.gettenTheloai());
            ps.setString(3, s.gettenTacgia());
            ps.setString(4, s.gettenNxb());
            ps.setString(5, ngayxb);
            ps.setInt(6, s.getsluong());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean DeleteSach(int id){
        String sql = "DELETE FROM sach WHERE id = ?";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            return false;
        }
    }
}
