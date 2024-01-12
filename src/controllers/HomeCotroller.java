package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */
public class HomeCotroller {
    private JLabel tongThietBiLb;
    private JLabel tongThietBiHongLb;

    public HomeCotroller(JLabel  tongThietBiLb,JLabel tongThietBiHongLb) {
        this. tongThietBiLb =  tongThietBiLb;
        this. tongThietBiHongLb = tongThietBiHongLb;
    }
    
    public void setData() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM thiet_bi";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this. tongThietBiLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            connection.close();
        } catch (Exception e) {
        }
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM `thiet_bi` WHERE `TrangThai` = 'Khong kha dung'";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this. tongThietBiHongLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            connection.close();
        } catch (Exception e) {
        }
        
    }

    public JLabel gettongThietBiLb() {
        return tongThietBiLb;
    }

    public void settongThietBiLb(JLabel tongThietBiLb) {
        this.tongThietBiLb = tongThietBiLb;
    } 

    public JLabel getTongThietBiHongLb() {
        return tongThietBiHongLb;
    }

    public void setTongThietBiHongLb(JLabel tongThietBiHongLb) {
        this.tongThietBiHongLb = tongThietBiHongLb;
    }
    
    
}
