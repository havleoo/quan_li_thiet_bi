package utility;


import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.thiet_bi;


public class ClassTableModel {
    // bang cho main frame
    public DefaultTableModel setTableThietBi(List<thiet_bi> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((thiet_bi item) -> {
            obj[0] = item.getMaTB();
            obj[1] = item.getTenTB();
            obj[2] = item.getTrangThai();
            obj[3] = item.getNgayThem();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
}
