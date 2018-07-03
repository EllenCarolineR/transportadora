package GUIs;
import DAOs.DAOTransporte;
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
public class GUITransporte extends JFrame {
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
private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
private Date data4;
private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
private JPanel pnCentro = new JPanel(new GridLayout(6, 2));
private JPanel pnSul = new JPanel(new GridLayout(1, 1));
private JLabel lbIdTransporte = new JLabel("IdTransporte");
private JTextField tfIdTransporte = new JTextField(10);
private JLabel lbOrigemDestino = new JLabel("OrigemDestino");
private JTextField tfOrigemDestino = new JTextField(10);
private JLabel lbFimDestino = new JLabel("FimDestino");
private JTextField tfFimDestino = new JTextField(10);
private JLabel lbValorFrete = new JLabel("ValorFrete");
private JTextField tfValorFrete = new JTextField(10);
private JLabel lbData = new JLabel("Data");
private JTextField tfData = new JTextField(10);
private JButton btEscolha4 = new JButton("Escolha");
private JPanel pnData = new JPanel(new GridLayout(1, 2));
private JPanel pnMotoristaIdMotorista = new JPanel(new GridLayout(1, 2));
private JLabel lbMotoristaIdMotorista = new JLabel("MotoristaIdMotorista");
private JTextField tfMotoristaIdMotorista = new JTextField();
private JButton btMotoristaIdMotorista = new JButton("Procurar");
private JPanel pnCaminhaoIdCaminhao = new JPanel(new GridLayout(1, 2));
private JLabel lbCaminhaoIdCaminhao = new JLabel("CaminhaoIdCaminhao");
private JTextField tfCaminhaoIdCaminhao = new JTextField();
private JButton btCaminhaoIdCaminhao = new JButton("Procurar");
ScrollPane scroll = new ScrollPane();
JTextArea jTextArea = new JTextArea();
JPanel aviso = new JPanel();
JLabel labelAviso = new JLabel("");
String qualAcao = "";//variavel para facilitar insert e update
DAOTransporte daoTransporte = new DAOTransporte();
Transporte transporte;
private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
public GUITransporte() {
setSize(900, 400);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setTitle("CRUD - Transporte");
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
cp.add(pnSul, BorderLayout.SOUTH);pnNorte.add(lbIdTransporte);
pnNorte.add(tfIdTransporte);
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
pnCentro.add(lbOrigemDestino);
pnCentro.add(tfOrigemDestino);
pnCentro.add(lbFimDestino);
pnCentro.add(tfFimDestino);
pnCentro.add(lbValorFrete);
pnCentro.add(tfValorFrete);
pnCentro.add(lbData);
pnCentro.add(pnData);
pnData.add(btEscolha4);
pnData.add(tfData);
pnCentro.add(lbMotoristaIdMotorista);
pnCentro.add(pnMotoristaIdMotorista);
pnMotoristaIdMotorista.add(tfMotoristaIdMotorista);
pnMotoristaIdMotorista.add(btMotoristaIdMotorista);
pnCentro.add(lbCaminhaoIdCaminhao);
pnCentro.add(pnCaminhaoIdCaminhao);
pnCaminhaoIdCaminhao.add(tfCaminhaoIdCaminhao);
pnCaminhaoIdCaminhao.add(btCaminhaoIdCaminhao);
pnSul.setBackground(Color.red);
scroll.add(jTextArea);
pnSul.add(scroll);
tfOrigemDestino.setEditable(false);
tfFimDestino.setEditable(false);
tfValorFrete.setEditable(false);
btEscolha4.setEnabled(false);
tfData.setEditable(false);
tfMotoristaIdMotorista.setEditable(false);
btMotoristaIdMotorista.setEnabled(false);
tfCaminhaoIdCaminhao.setEditable(false);
btCaminhaoIdCaminhao.setEnabled(false);
btnRetrieve.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
tfIdTransporte.setBackground(Color.white);
jTextArea.setText("");
transporte = new Transporte();
int identificador = Integer.valueOf(tfIdTransporte.getText());
transporte.setIdTransporte(identificador);
transporte = daoTransporte.obter(transporte.getIdTransporte());
if (transporte == null) {
pnNorte.setBackground(Color.red);
tfOrigemDestino.setText("");
tfFimDestino.setText("");
tfValorFrete.setText("");
tfData.setText("");
tfMotoristaIdMotorista.setText("");
tfCaminhaoIdCaminhao.setText("");
btnCreate.setVisible(true);
} else {
pnNorte.setBackground(Color.green);
tfOrigemDestino.setText(transporte.getOrigemDestino());
tfFimDestino.setText(transporte.getFimDestino());
tfValorFrete.setText(String.valueOf(transporte.getValorFrete()));
tfData.setText(sdf.format(transporte.getData()));
String dao1 = String.valueOf(transporte.getMotoristaIdMotorista());
String [] aux1 = dao1.split("-");
tfMotoristaIdMotorista.setText(aux1[0]);
String dao2 = String.valueOf(transporte.getCaminhaoIdCaminhao());
String [] aux2 = dao2.split("-");
tfCaminhaoIdCaminhao.setText(aux2[0]);
btnUpdate.setVisible(true);
btnDelete.setVisible(true);
btnCreate.setVisible(false);
}
tfIdTransporte.setEditable(false);
tfOrigemDestino.setEditable(false);
tfFimDestino.setEditable(false);
tfValorFrete.setEditable(false);
tfData.setEditable(false);
btMotoristaIdMotorista.setEnabled(false);
btCaminhaoIdCaminhao.setEnabled(false);
tfIdTransporte.selectAll();
} catch (Exception erro) {
pnNorte.setBackground(Color.yellow);
tfIdTransporte.requestFocus();
tfIdTransporte.setBackground(Color.red);
jTextArea.setText("Erro... \n");
jTextArea.append(erro.getMessage());
}
}
});
btnCreate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
tfIdTransporte.setEditable(false);
tfOrigemDestino.requestFocus();
btnCreate.setVisible(false);
btnSave.setVisible(true);
qualAcao = "incluir";
transporte = new Transporte();
tfOrigemDestino.setEditable(true);
tfFimDestino.setEditable(true);
tfValorFrete.setEditable(true);
btEscolha4.setEnabled(true);
btMotoristaIdMotorista.setEnabled(true);
btCaminhaoIdCaminhao.setEnabled(true);
tfIdTransporte.setEditable(false);
}
});
btnSave.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
transporte = new Transporte();
transporte.setIdTransporte(Integer.valueOf(tfIdTransporte.getText()));
transporte.setOrigemDestino(tfOrigemDestino.getText());
transporte.setFimDestino(tfFimDestino.getText());
transporte.setValorFrete(Double.valueOf(tfValorFrete.getText()));
sdf.setLenient(false);
data4 = sdf.parse(tfData.getText());
try {
transporte.setData(sdf.parse(tfData.getText()));} catch (ParseException ex) {
Logger.getLogger(GUITransporte.class
.getName()).log(Level.SEVERE, null, ex);
}
String [] aux0 = tfMotoristaIdMotorista.getText().split("-");
DAOMotorista daoMotorista = new DAOMotorista();
Motorista d0 = daoMotorista.obter(Integer.valueOf(aux0[0]));
transporte.setMotoristaIdMotorista(d0);
String [] aux1 = tfCaminhaoIdCaminhao.getText().split("-");
DAOCaminhao daoCaminhao = new DAOCaminhao();
Caminhao d1 = daoCaminhao.obter(Integer.valueOf(aux1[0]));
transporte.setCaminhaoIdCaminhao(d1);
if (qualAcao.equals("incluir")) {
daoTransporte.inserir(transporte);
} else {
daoTransporte.atualizar(transporte);
}
tfIdTransporte.setEditable(true);
tfIdTransporte.requestFocus();
tfOrigemDestino.setText("");
tfFimDestino.setText("");
tfValorFrete.setText("");
tfData.setText("");
tfMotoristaIdMotorista.setText("");
tfCaminhaoIdCaminhao.setText("");
btnSave.setVisible(false)
;pnNorte.setBackground(Color.green);
tfOrigemDestino.setEditable(false);
tfFimDestino.setEditable(false);
tfValorFrete.setEditable(false);
btEscolha4.setEnabled(false);
btMotoristaIdMotorista.setEnabled(false);
btCaminhaoIdCaminhao.setEnabled(false);
} catch (Exception erro){
jTextArea.append("Erro............");
tfIdTransporte.setEditable(true);
pnNorte.setBackground(Color.red); 
}
}
});
btnUpdate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
tfOrigemDestino.requestFocus();
btnSave.setVisible(true);
qualAcao = "editar";
tfOrigemDestino.setEditable(true);
tfFimDestino.setEditable(true);
tfValorFrete.setEditable(true);
btEscolha4.setEnabled(true);
btMotoristaIdMotorista.setEnabled(true);
btCaminhaoIdCaminhao.setEnabled(true);
}
});
btnDelete.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
"Confirma a exclusão do registro <ID = " + transporte.getIdTransporte() + ">?", "Confirm",
JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
daoTransporte.remover(transporte);
tfIdTransporte.requestFocus();
tfOrigemDestino.setText("");
tfFimDestino.setText("");
tfValorFrete.setText("");
tfData.setText("");
tfMotoristaIdMotorista.setText("");
tfCaminhaoIdCaminhao.setText("");
tfIdTransporte.setEditable(true);
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
}
}
});
btnList.addActionListener(new ActionListener() {
@Override
 public void actionPerformed(ActionEvent e) {
GUIListagemTransporte guiListagem = new GUIListagemTransporte(daoTransporte.list());
}
});
setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
dispose();
}
});
btEscolha4.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
DateChooser dc4 = new DateChooser((JFrame) null, "Escolha uma data");
data4 = dc4.select();
tfData.setText(sdf.format(data4));
} catch (Exception ex) {
jTextArea.setText("Escolha uma data\n");
}}
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
DAOCaminhao daoCaminhao = new DAOCaminhao();
btCaminhaoIdCaminhao.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoCaminhao.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfCaminhaoIdCaminhao.setText(aux[0]);
} else {
jTextArea.setText("Nenhum dado adicionado!");
}
}
}
});
tfIdTransporte.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoTransporte.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfIdTransporte.setText(aux[0]);
btnRetrieve.doClick();

} else {
tfIdTransporte.requestFocus();tfIdTransporte.selectAll();}
}
}
});
CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
setVisible(true);
}
public static void main(String[] args) {
GUITransporte guiTransporte = new GUITransporte();
}
}
