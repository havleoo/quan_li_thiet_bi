package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import services.MysqlConnection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import models.tt_dang_nhap;
import services.TaiKhoanService;


public class TaiKhoanManagerPanelController {
    public static tt_dang_nhap currentUser = new tt_dang_nhap();
    public static String TenDN;
            
    static void setTenDN(String TenDN) {
         TaiKhoanManagerPanelController.TenDN = TenDN;
    }   
    
    private JLabel TenDNLb;

    public TaiKhoanManagerPanelController(JLabel  TenDNLb) {
        this.TenDNLb =  TenDNLb;
    }
    
    public void setData() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT TenDN as Tendangnhap FROM tt_dang_nhap ";
            query += " WHERE tt_dang_nhap.TenDN = '" + TenDN + "'";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.TenDNLb.setText(String.valueOf(rs.getString("Tendangnhap")));
            }
            preparedStatement.close();
            connection.close();
        } 
        catch (Exception e) {
            
        }
    }
    
     public boolean DoiMK(String MatKhauHienTai, String MatKhauMoi, String MatKhauMoi2) throws SQLException, ClassNotFoundException{
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM tt_dang_nhap WHERE TenDN = '" + TenDN +"'");
        if (rs == null) {
            return false;
        }
        while (rs.next()) {                
            try{
                if (rs.getString("MatKhau") == null ? MatKhauHienTai == null : rs.getString("MatKhau").equals(MatKhauHienTai)) {
                    if (MatKhauMoi.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu mới!", "Warning!!", JOptionPane.ERROR_MESSAGE);   

                    }
                    else if (MatKhauMoi.equals(MatKhauMoi2)){
                        TaiKhoanService.DoiMK(TenDN,MatKhauMoi) ;
                        return true;
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Mật khẩu mới không khớp!", "Warning!!", JOptionPane.ERROR_MESSAGE);   
                    }
                }
                else {
                JOptionPane.showMessageDialog(null, "Sai mật khẩu hiện tại!", "Warning!!", JOptionPane.ERROR_MESSAGE);   
                }
            }
            catch (Exception e){
             JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!! Vui lòng kiểm tra lại!", "Warning!!", JOptionPane.ERROR_MESSAGE);   
            }
        }
        connection.close();
        return false;
    }
    
    public JLabel getTenDNLb() {
        return TenDNLb;
    }

    public void setTenDNLb(JLabel TenDNLb) {
        this.TenDNLb = TenDNLb;
    }

   
    
}
