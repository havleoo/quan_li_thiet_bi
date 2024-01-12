package controllers.ThietBiManagerController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import services.MysqlConnection;
import models.lich_muon;
import models.thiet_bi;
/**
 *
 * @author Hai
 */
public class DangKyMuonController {
    
    public String checkMaTB(String cmt) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thiet_bi WHERE MaTB = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cmt);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("MaTB");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thiết bị không khả dụng", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return null;

    }
    

    
    public int checkMaLop(String MaLop) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM tkb WHERE MaLop = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, MaLop);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("MaLop");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }
    
    public boolean addNew(lich_muon muon) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "INSERT INTO lich_muon(MaTB, NgayMuon, NgayTra)" + " value (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, muon.getMaTB());
            Date ngayMuon = new Date(muon.getNgayMuon().getTime());
            preparedStatement.setDate(2, ngayMuon);
            Date ngayTra = new Date(muon.getNgayTra().getTime());
            preparedStatement.setDate(3, ngayTra);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    
}
