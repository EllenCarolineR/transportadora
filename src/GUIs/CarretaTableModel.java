package GUIs;

import Entidades.Carreta;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CarretaTableModel extends AbstractTableModel {

    private final Class classes[] = new Class[]{Integer.class, String.class};
    private final String colunas[] = new String[]{"Placa/ID", "Capacidade Máxima"};
    private List<Carreta> dados;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //private final SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");

    public CarretaTableModel(List<Carreta> dados) {
        this.dados = dados;
    }

    public void setDados(List<Carreta> dados) {
        this.dados = dados;
    }

    public List<Carreta> getDados() {
        return this.dados;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Carreta s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIdCarreta();
            case 1:
                return s.getCapacidadeMax();
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        //  mudou = true;
        Carreta s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                s.setIdCarreta((String) aValue);
                break;
            case 1:
                try {
                    s.setCapacidadeMax(Double.valueOf((String) aValue));
                } catch (Exception e){
                    System.out.println("ERRO");
                }
                break;
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
        fireTableDataChanged();
    }

    public Carreta getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    public int indexOf(Carreta tc) {
        return dados.indexOf(tc);
    }

    public void onAdd(Carreta tipoConta) {
        dados.add(tipoConta);
        fireTableRowsInserted(indexOf(tipoConta), indexOf(tipoConta));
    }

    public void onRemove(int[] rowIndex) {
        int x;
        for (x = rowIndex.length - 1; x >= 0; x--) {
            dados.remove(rowIndex[x]);
            fireTableRowsDeleted(rowIndex[x], rowIndex[x]);
        }
    }
}
