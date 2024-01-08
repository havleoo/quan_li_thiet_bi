package controllers;

import Bean.ThietBiBean;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.thiet_bi;
import services.ThietBiService;
import services.StringService;
import utility.ClassTableModel;



public class ThongKePanelController {

    private JPanel jpnView;
    private ThietBiService ThietBiService;
    private List<ThietBiBean> listThietBiBean;
    private ClassTableModel classTableModel;
    private final String[] COLUMNS = {"Mã TB", "Tên TB", "Trạng thái", "Ngày thêm"};

    public ThongKePanelController(JPanel jpnView) {
        this.jpnView = jpnView;
        this.ThietBiService = new ThietBiService();
        this.listThietBiBean = new ArrayList<>();
        this.listThietBiBean = this.ThietBiService.getListThietBi();
        this.classTableModel = new ClassTableModel();
    }
    
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public void setData() {
        this.listThietBiBean = this.ThietBiService.statisticThietBi();
        setDataTable();
    }
    
    public void setDataTable() {
        List<thiet_bi> listItem = new ArrayList<>();
        this.listThietBiBean.forEach(thiet_bi -> {
            listItem.add(thiet_bi.getthiet_bi());
        });
        
        DefaultTableModel model = classTableModel.setTableNhanKhau(listItem, COLUMNS);
        JTable table = new JTable(model);
        
        // thiet ke bang
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
    
    
}
