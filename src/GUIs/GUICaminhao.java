package GUIs;
import DAOs.DAOCaminhao;
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
public class GUICaminhao extends JFrame {
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
private JPanel pnCentro = new JPanel(new GridLayout(3, 2));
private JPanel pnSul = new JPanel(new GridLayout(1, 1));
private JLabel lbIdCaminhao = new JLabel("IdCaminhao");
private JTextField tfIdCaminhao = new JTextField(10);
private JPanel pnCavaloIdCavalo = new JPanel(new GridLayout(1, 2));
private JLabel lbCavaloIdCavalo = new JLabel("Placa Cavalo");
private JTextField tfCavaloIdCavalo = new JTextField();
private JButton btCavaloIdCavalo = new JButton("Procurar");
private JPanel pnCarretaIdCarreta = new JPanel(new GridLayout(1, 2));
private JLabel lbCarretaIdCarreta = new JLabel("Placa carreta");
private JTextField tfCarretaIdCarreta = new JTextField();
private JButton btCarretaIdCarreta = new JButton("Procurar");
private JPanel pnMotoristaIdMotorista = new JPanel(new GridLayout(1, 2));
private JLabel lbMotoristaIdMotorista = new JLabel("Id Motorista");
private JTextField tfMotoristaIdMotorista = new JTextField();
private JButton btMotoristaIdMotorista = new JButton("Procurar");
ScrollPane scroll = new ScrollPane();
JTextArea jTextArea = new JTextArea();
JPanel aviso = new JPanel();
JLabel labelAviso = new JLabel("");
String qualAcao = "";//variavel para facilitar insert e update
DAOCaminhao daoCaminhao = new DAOCaminhao();
Caminhao caminhao;
private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
public GUICaminhao() {
setSize(900, 400);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setTitle("CRUD - Caminhao");
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
cp.add(pnSul, BorderLayout.SOUTH);pnNorte.add(lbIdCaminhao);
pnNorte.add(tfIdCaminhao);
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
pnCentro.add(lbCavaloIdCavalo);
pnCentro.add(pnCavaloIdCavalo);
pnCavaloIdCavalo.add(tfCavaloIdCavalo);
pnCavaloIdCavalo.add(btCavaloIdCavalo);
pnCentro.add(lbCarretaIdCarreta);
pnCentro.add(pnCarretaIdCarreta);
pnCarretaIdCarreta.add(tfCarretaIdCarreta);
pnCarretaIdCarreta.add(btCarretaIdCarreta);
pnCentro.add(lbMotoristaIdMotorista);
pnCentro.add(pnMotoristaIdMotorista);
pnMotoristaIdMotorista.add(tfMotoristaIdMotorista);
pnMotoristaIdMotorista.add(btMotoristaIdMotorista);
pnSul.setBackground(Color.red);
scroll.add(jTextArea);
pnSul.add(scroll);
tfCavaloIdCavalo.setEditable(false);
btCavaloIdCavalo.setEnabled(false);
tfCarretaIdCarreta.setEditable(false);
btCarretaIdCarreta.setEnabled(false);
tfMotoristaIdMotorista.setEditable(false);
btMotoristaIdMotorista.setEnabled(false);
btnRetrieve.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
tfIdCaminhao.setBackground(Color.white);
jTextArea.setText("");
caminhao = new Caminhao();
int identificador = Integer.valueOf(tfIdCaminhao.getText());
caminhao.setIdCaminhao(identificador);
caminhao = daoCaminhao.obter(caminhao.getIdCaminhao());
if (caminhao == null) {
pnNorte.setBackground(Color.red);
tfCavaloIdCavalo.setText("");
tfCarretaIdCarreta.setText("");
tfMotoristaIdMotorista.setText("");
btnCreate.setVisible(true);
} else {
pnNorte.setBackground(Color.green);
String dao1 = String.valueOf(caminhao.getCavaloIdCavalo());
String [] aux1 = dao1.split("-");
tfCavaloIdCavalo.setText(aux1[0]);
String dao2 = String.valueOf(caminhao.getCarretaIdCarreta());
String [] aux2 = dao2.split("-");
tfCarretaIdCarreta.setText(aux2[0]);
String dao3 = String.valueOf(caminhao.getMotoristaIdMotorista());
String [] aux3 = dao3.split("-");
tfMotoristaIdMotorista.setText(aux3[0]);
btnUpdate.setVisible(true);
btnDelete.setVisible(true);
btnCreate.setVisible(false);
}
tfIdCaminhao.setEditable(false);
btCavaloIdCavalo.setEnabled(false);
btCarretaIdCarreta.setEnabled(false);
btMotoristaIdMotorista.setEnabled(false);
tfIdCaminhao.selectAll();
} catch (Exception erro) {
pnNorte.setBackground(Color.yellow);
tfIdCaminhao.requestFocus();
tfIdCaminhao.setBackground(Color.red);
jTextArea.setText("Erro... \n");
jTextArea.append(erro.getMessage());
}
}
});
btnCreate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
tfIdCaminhao.setEditable(false);
tfCavaloIdCavalo.requestFocus();
btnCreate.setVisible(false);
btnSave.setVisible(true);
qualAcao = "incluir";
caminhao = new Caminhao();
btCavaloIdCavalo.setEnabled(true);
btCarretaIdCarreta.setEnabled(true);
btMotoristaIdMotorista.setEnabled(true);
tfIdCaminhao.setEditable(false);
}
});
btnSave.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
caminhao = new Caminhao();
caminhao.setIdCaminhao(Integer.valueOf(tfIdCaminhao.getText()));
String [] aux0 = tfCavaloIdCavalo.getText().split("-");
DAOCavalo daoCavalo = new DAOCavalo();
Cavalo d0 = daoCavalo.obter(aux0[0]);
caminhao.setCavaloIdCavalo(d0);
String [] aux1 = tfCarretaIdCarreta.getText().split("-");
DAOCarreta daoCarreta = new DAOCarreta();
Carreta d1 = daoCarreta.obter(aux1[0]);
caminhao.setCarretaIdCarreta(d1);
String [] aux2 = tfMotoristaIdMotorista.getText().split("-");
DAOMotorista daoMotorista = new DAOMotorista();
Motorista d2 = daoMotorista.obter(Integer.valueOf(aux2[0]));
caminhao.setMotoristaIdMotorista(d2);
if (qualAcao.equals("incluir")) {
daoCaminhao.inserir(caminhao);
} else {
daoCaminhao.atualizar(caminhao);
}
tfIdCaminhao.setEditable(true);
tfIdCaminhao.requestFocus();
tfCavaloIdCavalo.setText("");
tfCarretaIdCarreta.setText("");
tfMotoristaIdMotorista.setText("");
btnSave.setVisible(false)
;pnNorte.setBackground(Color.green);
btCavaloIdCavalo.setEnabled(false);
btCarretaIdCarreta.setEnabled(false);
btMotoristaIdMotorista.setEnabled(false);
} catch (Exception erro){
jTextArea.append("Erro............");
tfIdCaminhao.setEditable(true);
pnNorte.setBackground(Color.red); 
}
}
});
btnUpdate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
tfCavaloIdCavalo.requestFocus();
btnSave.setVisible(true);
qualAcao = "editar";
btCavaloIdCavalo.setEnabled(true);
btCarretaIdCarreta.setEnabled(true);
btMotoristaIdMotorista.setEnabled(true);
}
});
btnDelete.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
"Confirma a exclusão do registro <ID = " + caminhao.getIdCaminhao() + ">?", "Confirm",
JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
daoCaminhao.remover(caminhao);
tfIdCaminhao.requestFocus();
tfCavaloIdCavalo.setText("");
tfCarretaIdCarreta.setText("");
tfMotoristaIdMotorista.setText("");
tfIdCaminhao.setEditable(true);
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
}
}
});
btnList.addActionListener(new ActionListener() {
@Override
 public void actionPerformed(ActionEvent e) {
GUIListagemCaminhao guiListagem = new GUIListagemCaminhao(daoCaminhao.list());
}
});
setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
dispose();
}
});
DAOCavalo daoCavalo = new DAOCavalo();
btCavaloIdCavalo.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoCavalo.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfCavaloIdCavalo.setText(aux[0]);
} else {
jTextArea.setText("Nenhum dado adicionado!");
}
}
}
});
DAOCarreta daoCarreta = new DAOCarreta();
btCarretaIdCarreta.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoCarreta.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfCarretaIdCarreta.setText(aux[0]);
} else {
jTextArea.setText("Nenhum dado adicionado!");
}
}
}
});
DAOMotorista daoMotorista = new DAOMotorista();
btMotoristaIdMotorista.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoMotorista.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfMotoristaIdMotorista.setText(aux[0]);
} else {
jTextArea.setText("Nenhum dado adicionado!");
}
}
}
});
tfIdCaminhao.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoCaminhao.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfIdCaminhao.setText(aux[0]);
btnRetrieve.doClick();

} else {
tfIdCaminhao.requestFocus();tfIdCaminhao.selectAll();}
}
}
});
CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
setVisible(true);
}
public static void main(String[] args) {
GUICaminhao guiCaminhao = new GUICaminhao();
}
}
