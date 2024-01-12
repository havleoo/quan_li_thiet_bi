package services;

import controllers.LoginController;
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
import models.tt_dang_nhap;

/**
 *
 * @author Hai
 */
public class TaiKhoanService {
    // them moi ho khau
    public static boolean DoiMK(String TenDN,String MatKhauMoi) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "UPDATE `tt_dang_nhap` SET `MatKhau` = '"+ MatKhauMoi +"' WHERE `tt_dang_nhap`.`TenDN` = '"+ TenDN +"';";                 
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();  
        preparedStatement.close();
        connection.close();
        return true;
    }
    
    
}
