
package controllers;

import Bean.ThoiKhoaBieuBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import utility.TableModelThoiKhoaBieu;
import services.ThoiKhoaBieuService;
import view.infoViews.InfoJframe;

public class ThoiKhoaBieuPanelController {
    private List<ThoiKhoaBieuBean> list;
    private JTextField searchJtf;
    private JPanel tableJpn;
    private final ThoiKhoaBieuService thoiKhoaBieuService = new ThoiKhoaBieuService();
    private final TableModelThoiKhoaBieu tableModelAll = new TableModelThoiKhoaBieu();
    private final String COLUNMS[] = {"Mã lớp", "Mã giảng viên", "Thời gian bắt đầu", "Thời gian kết thúc"};
    private JFrame parentJFrame;
    
    public ThoiKhoaBieuPanelController(JTextField searchJtf,JPanel tableJpn){
        this.tableJpn = tableJpn;
        this.searchJtf = searchJtf;
        this.list = thoiKhoaBieuService.getListThoiKhoaBieu();
        setData();
        initAction();
    }
    
    public void initAction() {
        this.searchJtf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
                if (key.isEmpty()) {
                    list = thoiKhoaBieuService.getListThoiKhoaBieu();
                } else {    
                    list = thoiKhoaBieuService.search(key);
                }
                setData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
                if (key.isEmpty()) {
                    list = thoiKhoaBieuService.getListThoiKhoaBieu();
                } else {
                    list = thoiKhoaBieuService.search(key);
                }
                setData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
                if (key.isEmpty()) {
                    list = thoiKhoaBieuService.getListThoiKhoaBieu();
                } else {
                    list = thoiKhoaBieuService.search(key);
                }
                setData();
            }
        });
    }
    
    public void setData(){
        DefaultTableModel model = tableModelAll.setTableThoiKhoaBieu(list, COLUNMS);
        
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    ThoiKhoaBieuBean temp = list.get(table.getSelectedRow());
                    InfoJframe infoJframe = new InfoJframe(temp.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        tableJpn.removeAll();
        tableJpn.setLayout(new BorderLayout());
        tableJpn.add(scroll);
        tableJpn.validate();
        tableJpn.repaint();
    }
    
    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public List<ThoiKhoaBieuBean> getList() {
        return list;
    }
    
    public void setList(List<ThoiKhoaBieuBean> list) {
        this.list = list;
    }
    
    public JTextField getSearchJtf() {
        return searchJtf;
    }

    public void setSearchJtf(JTextField searchJtf) {
        this.searchJtf = searchJtf;
    }

    public JPanel getTableJpn() {
        return tableJpn;
    }

    public void setTableJpn(JPanel tableJpn) {
        this.tableJpn = tableJpn;
    }
    
    
}
