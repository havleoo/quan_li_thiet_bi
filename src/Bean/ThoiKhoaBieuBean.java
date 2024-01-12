package Bean;


import java.util.ArrayList;
import java.util.List;
import models.tkb;
import models.gvien;
import models.lich_muon;


public class ThoiKhoaBieuBean {
        private tkb tkb;
        private gvien gvien;
        private lich_muon lich_muon;
        private List<gvien> listgviens;
        
        public ThoiKhoaBieuBean(tkb tkb, gvien gvien,lich_muon lich_muon, List<gvien> listgviens){
            this.tkb = tkb;
            this.gvien = gvien;
            this.lich_muon = lich_muon;
            this.listgviens = listgviens;
        }
        
        public ThoiKhoaBieuBean(){
            this.tkb = new tkb();
            this.gvien = new gvien();
            this.lich_muon = new lich_muon();
            this.listgviens = new ArrayList<>(); 
        }
        
        
     public tkb gettkb() {
        return tkb;
    }

    public void settkb(tkb tkb) {
        this.tkb = tkb;
    }
    
    public gvien getGvien() {
        return gvien;
    }

    public void setGvien(gvien gvien) {
        this.gvien = gvien;
    }
    
    public lich_muon getLichmuon() {
        return lich_muon;
    }

    public void setLich_muon(lich_muon lich_muon) {
        this.lich_muon = lich_muon;
    }
    
    public List<gvien> getListGviens() {
        return listgviens;
    }

    public void setListGviens(List<gvien> listgviens) {
        this.listgviens = listgviens;
    }
    
 @Override
 public String toString(){
     
     String res = "<html> <style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
             + "<h3>Thông tin lớp học"
             + "<p>Mã lớp: <b>" + tkb.getMaLop() + "</p>"
             + "<p>Mã giáo viên: <b>" + tkb.getMaGV() + "</p>"
             + "<p>Mã môn: <b>" + tkb.getMaMon() + "</p>"
             + "<p>Tên môn: <b>" + tkb.getTenMon() + "</p>"
             + "<p>Thời gian bắt đầu: <b>" + tkb.getTgBatDau().toString() + "</p>"
             + "<p>Thời gian kết thúc: <b>" + tkb.getTgKetThuc().toString() + "</p>"
             + "<h4>Thông tin giáo viên<table>"
             + "<tr>"
             + "<th>Mã GV</th>"
             + "<th>Họ tên</th>"
             + "<th>Ngày sinh</th>"
             + "<th>Giới tính</th>"
             + "<th>Email</th>"
             + "</tr>";

for (int i = 0; i < listgviens.size(); i++) {
            res += "<tr>"
                    + "<td>"
                    + listgviens.get(i).getMaGV()
                    + "</td>"
                    + "<td>"
                    + listgviens.get(i).getHoTen()
                    + "</td>"
                    + "<td>"
                    + listgviens.get(i).getNgaySinh().toString()
                    + "</td>"
                    + "<td>"
                    + listgviens.get(i).getGioiTinh()
                    + "</td>"
                    + "<td>"
                    + listgviens.get(i).getEmail()
                    + "</td>"
                    + "</tr>";
        }
res += "</table></div></html>";
        return res;
}
}
