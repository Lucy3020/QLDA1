/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Object.TheDocgia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class TheDocgiaData {
    public static PreparedStatement ps;
    public static ResultSet rs;
    public TheDocgia Dangnhap(String taiKhoan, String pass) {
        TheDocgia t = null;
        try{
            ps = Connect.getConnect().prepareStatement("SELECT * FROM thedocgia where id = ? and password=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                t = new TheDocgia();

                t.setn(rs.getString("name"));   
                t.setbd(rs.getDate("birthday"));
                t.setphone(rs.getString("phone"));
                t.setadd(rs.getString("address"));
                t.setschool(rs.getString("school"));
            }
        }
        catch(Exception e) {
            return t = null;
        }
        return t;
    }
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static void InsertTheDocgia(TheDocgia t) {
        SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");//Khai bao kieu du lieu date
        String bd = date_format.format(t.getbd());
        String sql = "INSERT INTO thedocgia values(?,?,?,?,?,?,?)";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, t.getid());
            ps.setString(2, t.getpass());
            ps.setString(3, t.getn());
            ps.setString(4, bd);
            ps.setString(5, t.getphone());
            ps.setString(6, t.getadd());
            ps.setString(7, t.getschool());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm thẻ độc giả thành công!" , "Thông báo", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Thẻ độc giả không được thêm" , "Thông báo", 1);
        }
    }
     
    public boolean UpdateTheDocgia(TheDocgia t) {
        SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");//Khai bao kieu du lieu date
        String bd = date_format.format(t.getbd());
        try {
            ps = Connect.getConnect().prepareStatement("UPDATE thedocgia SET password = ?, name = ?,"
                    + "birthday = ?, phone = ?, address = ?, school = ? where id = ?");
            ps.setString(7, t.getid());
            ps.setString(1, t.getpass());
            ps.setString(2, t.getn());
            ps.setString(3, bd);
            ps.setString(4, t.getphone());
            ps.setString(5, t.getadd());
            ps.setString(6, t.getschool());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteTheDocgia(String mathe) {
        try {
            ps = Connect.getConnect().prepareStatement("DELETE FROM thedocgia WHERE id = ?");
            ps.setString(1, mathe);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}
