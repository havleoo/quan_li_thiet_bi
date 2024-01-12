package controllers.ThietBiManagerController;

import Bean.ThietBiBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.thiet_bi;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */

// lop thuc hien cac chuc nang trong giao dien them moi nhan khau

public class ThemThietBiController {
    public boolean addNewPeople(ThietBiBean ThietBiBean) throws SQLException, ClassNotFoundException{
        thiet_bi thiet_bi = ThietBiBean.getthiet_bi();
        //ChungMinhThuModel chungMinhThu = nhanKhauBean.getChungMinhThuModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        // 1 - 19
        String query = "INSERT INTO thiet_bi (MaTB, TenTB, TrangThai, NgayThem)" 
                        + " values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, thiet_bi.getMaTB());
        preparedStatement.setString(2, thiet_bi.getTenTB());
        preparedStatement.setString(3, thiet_bi.getTrangThai());
        java.sql.Date createDate = new java.sql.Date(quanlythietbi.QuanLyThietBi.calendar.getTime().getTime());
        preparedStatement.setDate(4, createDate);
        
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
      
        if (rs.next()) {
            int genID = rs.getInt(1);
            String sql = "INSERT INTO thiet_bi(MaTB, TenTB)" 
                        + " values (?, ?)";
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1, genID);
            prst.setString(2, thiet_bi.getMaTB());
            prst.setString(3, thiet_bi.getTenTB());
            prst.setString(4, thiet_bi.getTrangThai());
            prst.execute();
            
        }
        connection.close();
        return true;
    }
}
