package controllers.ThietBiManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import models.bao_cao_su_co;
import models.thiet_bi;
import services.MysqlConnection;


public class BaoCaoSuCoController {

    public String checkMaTB(String cmt){
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thiet_bi WHERE MaTB = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cmt);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("MaTB");
            }
        }
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
    }
        return null;
}
    
    public boolean addNew(bao_cao_su_co bao_cao_su_co, thiet_bi thiet_bi) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String insertquery = "INSERT INTO `bao_cao_su_co` (`MaGV`, `MaTB`, `MoTaSuCo`) VALUES (?, ?, ?)";
                  
            PreparedStatement insertStatement = connection.prepareStatement(insertquery);
            insertStatement.setString(1, bao_cao_su_co.getMaGV());
            insertStatement.setString(2, bao_cao_su_co.getMaTB());
            insertStatement.setString(3, bao_cao_su_co.getMoTaSuCo());
            insertStatement.execute();
            
            String updatequery = " UPDATE `thiet_bi` SET `TrangThai` = 'Không khả dụng' where `MaTB` = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updatequery);
            updateStatement.setString(1, thiet_bi.getMaTB());
            updateStatement.execute();
                    
                    
            insertStatement.close();
            updateStatement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    
   
}