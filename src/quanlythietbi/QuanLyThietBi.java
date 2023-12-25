
package quanlythietbi;
import java.sql.*;
import javax.swing.JOptionPane;
import services.MysqlConnection;

public class QuanLyThietBi {
public static void main(String[] args) throws SQLException, ClassNotFoundException{

 
        Connection connection = MysqlConnection.getMysqlConnection();
        if (connection != null) {
            System.out.println("nice");
        }

	}
    
}
