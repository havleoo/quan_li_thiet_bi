package services;

import Bean.ThietBiBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.thiet_bi;


public class ThietBiService {
    public ThietBiBean getThietBi(String MaTB) {
        ThietBiBean ThietBiBean = new ThietBiBean();  
        // truy cap db
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thiet_bi WHERE MaTB = ?" + MaTB;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                thiet_bi thiet_bi = ThietBiBean.getthiet_bi();
                thiet_bi.setMaTB(rs.getString("MaTB"));
                thiet_bi.setTenTB(rs.getString("TenTB"));
                thiet_bi.setTrangThai(rs.getString("TrangThai"));
                thiet_bi.setNgayThem(rs.getDate("NgayThem"));
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return ThietBiBean;
    } 
    
public List<ThietBiBean> getListThietBi() {
        List<ThietBiBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thiet_bi ";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ThietBiBean ThietBiBean = new ThietBiBean();
                thiet_bi thiet_bi = ThietBiBean.getthiet_bi();
                thiet_bi.setMaTB(rs.getString("MaTB"));
                thiet_bi.setTenTB(rs.getString("TenTB"));
                thiet_bi.setTrangThai(rs.getString("TrangThai"));
                thiet_bi.setNgayThem(rs.getDate("NgayThem"));
    
                list.add(ThietBiBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
     
public List<ThietBiBean> statisticThietBi(String TrangThai) {
        List<ThietBiBean> list = new ArrayList<>();
        
        String query = "SELECT * FROM thiet_bi ";
        if (!TrangThai.equalsIgnoreCase("Toan Bo")) {
            query += " WHERE thiet_bi.TrangThai = '" + TrangThai + "'";
        }          
        query += " ORDER BY MaTB ";
         try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ThietBiBean  ThietBiBean = new ThietBiBean();
                thiet_bi thiet_bi = ThietBiBean.getthiet_bi();
                thiet_bi.setMaTB(rs.getString("MaTB"));
                thiet_bi.setTenTB(rs.getString("TenTB"));
                thiet_bi.setTrangThai(rs.getString("TrangThai"));
                thiet_bi.setNgayThem(rs.getDate("NgayThem"));
                
                list.add(ThietBiBean);
            }
            preparedStatement.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        
        return list;
    }
       
    /*
     * ham tim kiem thiet bi theo ten
     */
    public List<ThietBiBean> search(String keyword) {
        List<ThietBiBean> list = new  ArrayList<>();
        String query;
        if (keyword.trim().isEmpty()) {
            return this.getListThietBi();
        }
        // truy cap db
        // create query
        try {
            String a = String.valueOf(keyword);
            query = "SELECT * "
                    + "FROM thiet_bi "
                    + "WHERE MaTB LIKE '%"
                    + keyword
                    + "%'";
        } catch (Exception e) {
            query = "SELECT * "
                    + "FROM thiet_bi "
                    + "WHERE MATCH(TenTB) AGAINST ('"
                    + keyword
                    + "' IN NATURAL LANGUAGE MODE);";
        }
        
        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ThietBiBean temp = new ThietBiBean();
                thiet_bi thiet_bi = temp.getthiet_bi();
                thiet_bi.setMaTB(rs.getString("MaTB"));
                thiet_bi.setTenTB(rs.getString("TenTB"));
                thiet_bi.setTrangThai(rs.getString("TrangThai"));
                thiet_bi.setNgayThem(rs.getDate("NgayThem"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
