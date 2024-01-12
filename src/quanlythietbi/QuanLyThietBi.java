package quanlythietbi;

import java.util.Calendar;
import javax.swing.UIManager;
import views.LoginUI;
import views.MainFrame;

public class QuanLyThietBi {

    public static Calendar calendar = Calendar.getInstance();
    
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true); 
    }
}
