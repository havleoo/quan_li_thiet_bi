
package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.tt_dang_nhap;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */
public class LoginController {
    
    public static tt_dang_nhap currentUser = new tt_dang_nhap();
    
    public boolean login(String TenDN, String MatKhau) throws SQLException, ClassNotFoundException{
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM tt_dang_nhap WHERE TenDN = '" + TenDN +"'");
        if (rs == null) {
            return false;
        }
        while (rs.next()) {                
            if (rs.getString("MatKhau") == null ? MatKhau == null : rs.getString("MatKhau").equals(MatKhau)) {
                LoginController.currentUser.setID(rs.getString("ID"));
                LoginController.currentUser.setTenDN(rs.getString("TenDN"));
                return true;
            }
        }
        connection.close();
        return false;
    }
}
