package controllers;

import Bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import views.HomePagePanel;
import views.ThongKePanel;
import views.ThoiKhoaBieuManagePanel;
import views.ThietBiManagePanel;
import views.TaiKhoanManagerPanel;

public class MainController {
    private JFrame jfrMain;
    private JPanel root;
    private String kindSelected;
    private List<DanhMucBean> listDanhMuc;

    public MainController(JPanel root, JFrame jfrMain) {
        this.jfrMain = jfrMain;
        this.root = root;
    }
    
    
    // set panel for root
    public void setView(JPanel jpnItem, JLabel jlbItem, String kind) {
        this.kindSelected = kind;
        jpnItem.setBackground(new Color(153,204,255));
        jlbItem.setBackground(new Color(153,204,255));
        JPanel view = new  JPanel();
        switch(kind) {
                case "TrangChu":
                    view = new HomePagePanel();
                    break;  
                case "ThietBi":
                    view = new ThietBiManagePanel(this.jfrMain);
                    break;   
                case "ThoiKhoaBieu":
                    view = new ThoiKhoaBieuManagePanel(this.jfrMain);
                    break;
                case "ThongKe":
                    view = new ThongKePanel(this.jfrMain);
                    break;
                case "TaiKhoan":
                    view = new TaiKhoanManagerPanel(this.jfrMain);
                    break;
                //any more
                default:
                    break;
            }
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(view);
        root.validate();
        root.repaint();
    } 
    
    //set animation for menu panel
    public void setEvent(List<DanhMucBean> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        this.listDanhMuc.forEach((item) -> {
            item.getJlb().addMouseListener(new LabelEvent(this.jfrMain, item.getKind(), item.getJpn(), item.getJlb()));
        });
    }

    public void setDefaultColor() {
        this.listDanhMuc.forEach((item) -> {
            if (item.getKind().equals("TrangChu")) {
                item.getJlb().setBackground(new Color(153,204,255));
                item.getJpn().setBackground(new Color(153,204,255));
            } else {
                item.getJlb().setBackground(new Color(153,204,255));
                item.getJpn().setBackground(new Color(153,204,255));
            }
        });
    }
    
    class LabelEvent implements MouseListener {
        
        private JPanel view;
        private JFrame jfrMain;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        public LabelEvent(JFrame jfrMain, String kind, JPanel jpnItem, JLabel jlbItem) {
            this.jfrMain = jfrMain;
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind) {
                case "TrangChu":
                    view = new HomePagePanel();
                    break;
                case "ThietBi":
                    view = new ThietBiManagePanel(this.jfrMain);
                    break;  
                case "ThoiKhoaBieu":
                    view = new ThoiKhoaBieuManagePanel(this.jfrMain);
                    break;
                case "ThongKe":
                    view = new ThongKePanel(this.jfrMain);
                    break;
                case "TaiKhoan":
                    view = new TaiKhoanManagerPanel(this.jfrMain);
                    break;
                default:
                    break;
            }
            
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(view);
            root.validate();
            root.repaint();
            setDefaultColor();
            jlbItem.setBackground(new Color(51,153,255));
            jpnItem.setBackground(new Color(51,153,255));
        }        

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jlbItem.setBackground(new Color(51,153,255));
            jpnItem.setBackground(new Color(51,153,255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jlbItem.setBackground(new Color(51,153,255));
            jpnItem.setBackground(new Color(51,153,255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kind.equalsIgnoreCase(kindSelected)) {
                if (kind.equals("TrangChu")) {
                    jlbItem.setBackground(new Color(153,204,255));
                    jpnItem.setBackground(new Color(153,204,255));
                } else 
                {
                    jlbItem.setBackground(new Color(153,204,255));
                    jpnItem.setBackground(new Color(153,204,255));
                }
            }
        }
        
    }
}
