package views;

import controllers.ThietBiManagerPanelController;
import javax.swing.JFrame;
import views.ThietBiManagerFrame.BaoCaoSuCoJFrame;
import views.ThietBiManagerFrame.DangKyMuonJFrame;
import views.ThietBiManagerFrame.ThemThietBiJFrame;


public class ThietBiManagePanel extends javax.swing.JPanel {

    
    private ThietBiManagerPanelController controller = null;
    private JFrame parentJFrame;
    
    public ThietBiManagePanel(JFrame parentFrame) {
        this.parentJFrame = parentFrame;
        initComponents();
        controller = new ThietBiManagerPanelController(tablePanel, jtfSearch);
        controller.setParentJFrame(parentJFrame);
        controller.setDataTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePanel = new javax.swing.JPanel();
        jtfSearch = new javax.swing.JTextField();
        BaoCaoSuCoBtn = new javax.swing.JButton();
        ThemThietBiBtn = new javax.swing.JButton();
        DangKyMuonBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jtfSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });

        BaoCaoSuCoBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BaoCaoSuCoBtn.setText("Báo cáo sự cố");
        BaoCaoSuCoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaoCaoSuCoBtnActionPerformed(evt);
            }
        });

        ThemThietBiBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThemThietBiBtn.setText("Thêm thiết bị");
        ThemThietBiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemThietBiBtnActionPerformed(evt);
            }
        });

        DangKyMuonBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DangKyMuonBtn.setText("Đăng kí mượn");
        DangKyMuonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangKyMuonBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 400, Short.MAX_VALUE))
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BaoCaoSuCoBtn)
                    .addComponent(ThemThietBiBtn)
                    .addComponent(DangKyMuonBtn))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BaoCaoSuCoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(ThemThietBiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(DangKyMuonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void BaoCaoSuCoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaoCaoSuCoBtnActionPerformed
        // TODO add your handling code here:
        BaoCaoSuCoJFrame baoCaoSuCoJFrame = new BaoCaoSuCoJFrame(this.parentJFrame);
        baoCaoSuCoJFrame.setLocationRelativeTo(null);
        baoCaoSuCoJFrame.setResizable(false);
        baoCaoSuCoJFrame.setVisible(true);
    }//GEN-LAST:event_BaoCaoSuCoBtnActionPerformed

    private void ThemThietBiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemThietBiBtnActionPerformed
        // TODO add your handling code here:
        ThemThietBiJFrame themThietBiJFrame = new ThemThietBiJFrame(this.parentJFrame);
        themThietBiJFrame.setLocationRelativeTo(null);
        themThietBiJFrame.setResizable(false);
        themThietBiJFrame.setVisible(true);
    }//GEN-LAST:event_ThemThietBiBtnActionPerformed

    private void DangKyMuonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangKyMuonBtnActionPerformed
        // TODO add your handling code here:
        DangKyMuonJFrame dangKyMuonJFrame = new DangKyMuonJFrame(this.parentJFrame);
        dangKyMuonJFrame.setLocationRelativeTo(null);
        dangKyMuonJFrame.setResizable(false);
        dangKyMuonJFrame.setVisible(true);
    }//GEN-LAST:event_DangKyMuonBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BaoCaoSuCoBtn;
    private javax.swing.JButton DangKyMuonBtn;
    private javax.swing.JButton ThemThietBiBtn;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JPanel tablePanel;
    // End of variables declaration//GEN-END:variables
}
