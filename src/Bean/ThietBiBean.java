package Bean;

import java.util.ArrayList;
import java.util.List;
import models.thiet_bi;

public class ThietBiBean {
    private thiet_bi thiet_bi_model;
    
    
    public ThietBiBean(thiet_bi thiet_bi) {
        this.thiet_bi_model = thiet_bi;
    }

    public ThietBiBean() {
        this.thiet_bi_model = new thiet_bi();
     
    }
    
    public thiet_bi getthiet_bi() {
        return thiet_bi_model;
    }

    public void setthiet_bi(thiet_bi thiet_bi) {
        this.thiet_bi_model = thiet_bi;
    }

    
    
    @Override
    public String toString() {
        String res =  "<html><style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
                + "<h3>Thông tin cơ bản:"
                + "<p>Mã thiết bị: <b>" + thiet_bi_model.getMaTB() + "</p>"
                + "<p>Tên thiết bị: <b>" + thiet_bi_model.getTenTB() + "</p>"
                + "<p>Trạng thái: <b>" + thiet_bi_model.getTrangThai() + "</p>"
                + "<p>Ngày thêm: <b>" + thiet_bi_model.getNgayThem()+ "</p>";
        res +=  "</table>"
                + "</div></html>";

        return res;
    }
}
