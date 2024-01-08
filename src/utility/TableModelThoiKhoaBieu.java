package utility;




import java.util.List;
import javax.swing.table.DefaultTableModel;
import Bean.ThoiKhoaBieuBean;

public class TableModelThoiKhoaBieu {
    
    public DefaultTableModel setTableThoiKhoaBieu(List<ThoiKhoaBieuBean> listItem, String[] listColumn){
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
          @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column);
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }  
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((ThoiKhoaBieuBean item) -> {
            obj[0] = item.gettkb().getMaLop();
            obj[1] = item.getGvien().getMaGV();
            obj[2] = item.gettkb().getTgBatDau();
            obj[3] = item.gettkb().getTgKetThuc();
            dtm.addRow(obj);
    });
        return dtm;
    }
}
