package GUIs;
import DAOs.DAOCavalo;
import Entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Image;
import javax.swing.JTextField;
import tools.*;
import DAOs.*;
public class GUICavalo extends JFrame {
ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
JButton btnCreate = new JButton(iconeCreate);
JButton btnRetrieve = new JButton(iconeRetrieve);
JButton btnUpdate = new JButton(iconeUpdate);
JButton btnDelete = new JButton(iconeDelete);
JButton btnSave = new JButton(iconeSave);
JButton btnCancel = new JButton(iconeCancel);
JButton btnList = new JButton(iconeListar);
private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
private JPanel pnCentro = new JPanel(new GridLayout(1, 2));
private JPanel pnSul = new JPanel(new GridLayout(1, 1));
private JLabel lbIdCavalo = new JLabel("IdCavalo");
private JTextField tfIdCavalo = new JTextField(10);
private JLabel lbMarca = new JLabel("Marca");
private JTextField tfMarca = new JTextField(10);
ScrollPane scroll = new ScrollPane();
JTextArea jTextArea = new JTextArea();
JPanel aviso = new JPanel();
JLabel labelAviso = new JLabel("");
String qualAcao = "";//variavel para facilitar insert e update
DAOCavalo daoCavalo = new DAOCavalo();
Cavalo cavalo;
private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
public GUICavalo() {
setSize(900, 400);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setTitle("CRUD - Cavalo");
Container cp = getContentPane();cp = getContentPane();
btnCreate.setToolTipText("Inserir novo registro");
btnRetrieve.setToolTipText("Pesquisar por chave");
btnUpdate.setToolTipText("Alterar");
btnDelete.setToolTipText("Excluir");
btnList.setToolTipText("Listar todos");
btnSave.setToolTipText("Salvar");
btnCancel.setToolTipText("Cancelar");cp.setLayout(new BorderLayout());
cp.add(pnNorte, BorderLayout.NORTH);
cp.add(pnCentro, BorderLayout.CENTER);
cp.add(pnSul, BorderLayout.SOUTH);pnNorte.add(lbIdCavalo);
pnNorte.add(tfIdCavalo);
pnNorte.add(btnRetrieve);
pnNorte.add(btnCreate);
pnNorte.add(btnUpdate);
pnNorte.add(btnDelete);
pnNorte.add(btnSave);
pnNorte.add(btnList);
btnCancel.setVisible(false);
btnDelete.setVisible(false);
btnCreate.setVisible(false);
btnSave.setVisible(false);
btnUpdate.setVisible(false);
pnCentro.add(lbMarca);
pnCentro.add(tfMarca);
pnSul.setBackground(Color.red);
scroll.add(jTextArea);
pnSul.add(scroll);
tfMarca.setEditable(false);
btnRetrieve.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
tfIdCavalo.setBackground(Color.white);
jTextArea.setText("");
cavalo = new Cavalo();
String identificador = tfIdCavalo.getText();
cavalo.setIdCavalo(identificador);
cavalo = daoCavalo.obter(cavalo.getIdCavalo());
if (cavalo == null) {
pnNorte.setBackground(Color.red);
tfMarca.setText("");
btnCreate.setVisible(true);
} else {
pnNorte.setBackground(Color.green);
tfMarca.setText(cavalo.getMarca());
btnUpdate.setVisible(true);
btnDelete.setVisible(true);
btnCreate.setVisible(false);
}
tfIdCavalo.setEditable(false);
tfMarca.setEditable(false);
tfIdCavalo.selectAll();
} catch (Exception erro) {
pnNorte.setBackground(Color.yellow);
tfIdCavalo.requestFocus();
tfIdCavalo.setBackground(Color.red);
jTextArea.setText("Erro... \n");
jTextArea.append(erro.getMessage());
}
}
});
btnCreate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
tfIdCavalo.setEditable(false);
tfMarca.requestFocus();
btnCreate.setVisible(false);
btnSave.setVisible(true);
qualAcao = "incluir";
cavalo = new Cavalo();
tfMarca.setEditable(true);
tfIdCavalo.setEditable(false);
}
});
btnSave.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
cavalo = new Cavalo();
cavalo.setIdCavalo(tfIdCavalo.getText());
cavalo.setMarca(tfMarca.getText());
if (qualAcao.equals("incluir")) {
daoCavalo.inserir(cavalo);
} else {
daoCavalo.atualizar(cavalo);
}
tfIdCavalo.setEditable(true);
tfIdCavalo.requestFocus();
tfMarca.setText("");
btnSave.setVisible(false)
;pnNorte.setBackground(Color.green);
tfMarca.setEditable(false);
} catch (Exception erro){
jTextArea.append("Erro............");
tfIdCavalo.setEditable(true);
pnNorte.setBackground(Color.red); 
}
}
});
btnUpdate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
tfMarca.requestFocus();
btnSave.setVisible(true);
qualAcao = "editar";
tfMarca.setEditable(true);
}
});
btnDelete.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
"Confirma a exclusão do registro <ID = " + cavalo.getIdCavalo() + ">?", "Confirm",
JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
daoCavalo.remover(cavalo);
tfIdCavalo.requestFocus();
tfMarca.setText("");
tfIdCavalo.setEditable(true);
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
}
}
});
btnList.addActionListener(new ActionListener() {
@Override
 public void actionPerformed(ActionEvent e) {
GUIListagemCavalo guiListagem = new GUIListagemCavalo(daoCavalo.list());
}
});
setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
dispose();
}
});
tfIdCavalo.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoCavalo.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfIdCavalo.setText(aux[0]);
btnRetrieve.doClick();

} else {
tfIdCavalo.requestFocus();tfIdCavalo.selectAll();}
}
}
});
CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
setVisible(true);
}
public static void main(String[] args) {
GUICavalo guiCavalo = new GUICavalo();
}
}
