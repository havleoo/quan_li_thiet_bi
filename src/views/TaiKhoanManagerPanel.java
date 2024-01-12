package views;

import controllers.TaiKhoanManagerPanelController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import services.TaiKhoanService;


public class TaiKhoanManagerPanel extends javax.swing.JPanel {

    private TaiKhoanManagerPanelController controller = null;
    private JFrame parentJFrame;
    
    public TaiKhoanManagerPanel(JFrame parentFrame) {
        this.parentJFrame = parentFrame;
        initComponents();
        controller = new TaiKhoanManagerPanelController(TenDNLb);
        controller.setData();
        keyListenner(txbMatKhauHienTai);
        keyListenner(txbMatKhauMoi);
        keyListenner(txbMatKhauMoi2);
    }
    
    // xu ly su kien nhan enter
    private void keyListenner(JTextField jtf) {
        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // neu keycode == 10 ~ enter
                if (e.getKeyCode() == 10) {
                    DoiMatKhau();
                }
            }
        }); 
    }

    // doi mat khau
    private void DoiMatKhau() {
        String MatKhauHienTai = String.valueOf(txbMatKhauHienTai.getPassword());
        String MatKhauMoi = String.valueOf(txbMatKhauMoi.getPassword());
        String MatKhauMoi2 = String.valueOf(txbMatKhauMoi2.getPassword());
        
        try {
            if (this.controller.DoiMK(MatKhauHienTai,MatKhauMoi,MatKhauMoi2)) {
               JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
            } 
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!! Vui lòng kiểm tra lại!", "Warning!!", JOptionPane.ERROR_MESSAGE);
        }
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TenDNLb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txbMatKhauHienTai = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txbMatKhauMoi = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txbMatKhauMoi2 = new javax.swing.JPasswordField();
        btnXacNhan = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));
        setForeground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(851, 465));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/key.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên đăng nhập của bạn:");

        TenDNLb.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        TenDNLb.setForeground(new java.awt.Color(255, 255, 255));
        TenDNLb.setText("x");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel7.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        jLabel7.setText("Đổi mật khẩu");

        jLabel5.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        jLabel5.setText("Mật khẩu cũ:");

        txbMatKhauHienTai.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txbMatKhauHienTai.setName("txtPasswd"); // NOI18N
        txbMatKhauHienTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbMatKhauHienTaiActionPerformed(evt);
            }
        });

        jLabel6.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        jLabel6.setText("Mật khẩu mới:");

        txbMatKhauMoi.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txbMatKhauMoi.setName("txtPasswd"); // NOI18N

        jLabel8.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        jLabel8.setText("Nhập lại mật khẩu mới:");

        txbMatKhauMoi2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txbMatKhauMoi2.setName("txtPasswd"); // NOI18N

        btnXacNhan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXacNhanMouseClicked(evt);
            }
        });
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(txbMatKhauHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(txbMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txbMatKhauMoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txbMatKhauHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txbMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txbMatKhauMoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(TenDNLb))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TenDNLb, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel4))))
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXacNhanMouseClicked

    }//GEN-LAST:event_btnXacNhanMouseClicked

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        this.DoiMatKhau();
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txbMatKhauHienTaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbMatKhauHienTaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbMatKhauHienTaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TenDNLb;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txbMatKhauHienTai;
    private javax.swing.JPasswordField txbMatKhauMoi;
    private javax.swing.JPasswordField txbMatKhauMoi2;
    // End of variables declaration//GEN-END:variables
}
