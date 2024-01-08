
package services;

import Bean.ThoiKhoaBieuBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.tkb;
import models.gvien;

public class ThoiKhoaBieuService {
    //lấy ra thời khóa biểu
    public List<ThoiKhoaBieuBean> getListThoiKhoaBieu(){
        List<ThoiKhoaBieuBean> list = new ArrayList<>();
        
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM tkb INNER JOIN giang_vien ON tkb.MaGV = giang_vien.MaGV ORDER BY MaLop LIMIT 0, 10";
             PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery();
             while (rs.next()){
                 ThoiKhoaBieuBean temp = new ThoiKhoaBieuBean();
                 tkb tkb = temp.gettkb();
                 tkb.setMaLop(rs.getString("MaLop"));
                 tkb.setTenMon(rs.getString("TenMon"));
                 tkb.setMaMon(rs.getString("MaMon"));
                 tkb.setTgBatDau(rs.getTimestamp("TGBatDau"));
                 tkb.setTgKetThuc(rs.getTimestamp("TGKetThuc"));
                 tkb.setMaGV(rs.getString("MaGV"));
                 gvien gvien = temp.getGvien();
                 gvien.setMaGV(rs.getString("MaGV"));
                 gvien.setHoTen(rs.getString("HoTen"));
                 gvien.setNgaySinh(rs.getTimestamp("NgaySinh"));
                 gvien.setGioiTinh(rs.getString("GioiTinh"));
                 gvien.setEmail(rs.getString("Email"));
                 list.add(temp);
             }
             preparedStatement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
    }
    return list;
    
}

    //tim kiem
    public List<ThoiKhoaBieuBean> search(String key){
        List<ThoiKhoaBieuBean> list = new ArrayList<>();
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * "
                    + "FROM tkb "
                    + "INNER JOIN giang_vien "
                    + "ON tkb.MaGV = giang_vien.MaGV "
                    + "WHERE MaLop like '%" 
                    + key
                    +"%'";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ThoiKhoaBieuBean temp = new ThoiKhoaBieuBean();
                tkb tkb = temp.gettkb();
                tkb.setMaLop(rs.getString("MaLop"));
                tkb.setTenMon(rs.getString("TenMon"));
                tkb.setMaMon(rs.getString("MaMon"));
                tkb.setTgBatDau(rs.getTimestamp("TGBatDau"));
                tkb.setTgKetThuc(rs.getTimestamp("TGKetThuc"));
                tkb.setMaGV(rs.getString("MaGV"));
                gvien gvien = temp.getGvien();
                gvien.setMaGV(rs.getString("MaGV"));
                gvien.setHoTen(rs.getString("HoTen"));
                gvien.setNgaySinh(rs.getTimestamp("NgaySinh"));
                gvien.setGioiTinh(rs.getString("GioiTinh"));
                gvien.setEmail(rs.getString("Email"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        }
    catch (Exception e) {
            System.out.println(e.getMessage());
    }
        return list;
    }
}
