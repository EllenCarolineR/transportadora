package GUIs;
import DAOs.DAOMotorista;
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
public class GUIMotorista extends JFrame {
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
private JPanel pnE1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
private JPanel pnE2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
private JPanel pnE3 = new JPanel(new GridLayout(1, 1));
private JLabel lbIdMotorista = new JLabel("IdMotorista");
private JTextField tfIdMotorista = new JTextField(10);
private JLabel lbNomeMotorista = new JLabel("Nome");
private JTextField tfNomeMotorista = new JTextField(10);
private JLabel lbTelefoneMotorista = new JLabel("Telefone");
private JTextField tfTelefoneMotorista = new JTextField(10);
private JLabel lbEnderecoMotorista = new JLabel("Endereço");
private JTextField tfEnderecoMotorista = new JTextField(10);
JTextField tfCaminho = new JTextField();
ScrollPane scroll = new ScrollPane();
JTextArea jTextArea = new JTextArea();
JPanel aviso = new JPanel();
JLabel labelAviso = new JLabel("");
String qualAcao = "";//variavel para facilitar insert e update
DAOMotorista daoMotorista = new DAOMotorista();
Motorista motorista;
private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
private JPanel pnEsquerda = new JPanel(new BorderLayout());
private JPanel pnDireita = new JPanel(new BorderLayout());
private JLabel rotulo = new JLabel();
private JButton btAbrirImagem = new JButton("Selecionar imagem");
private String caminho;
private Image imagemAux;
private ImageIcon icone;
public GUIMotorista() {
setSize(900, 400);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setTitle("CRUD - Motorista");
Container cp = getContentPane();cp = getContentPane();
btnCreate.setToolTipText("Inserir novo registro");
btnRetrieve.setToolTipText("Pesquisar por chave");
btnUpdate.setToolTipText("Alterar");
btnDelete.setToolTipText("Excluir");
btnList.setToolTipText("Listar todos");
btnSave.setToolTipText("Salvar");
btnCancel.setToolTipText("Cancelar");cp.setLayout(new GridLayout(1, 2));
cp.add(pnEsquerda);
cp.add(pnDireita);
try {
String caminho = "";
tfCaminho.setText(caminho);
icone = new ImageIcon(getClass().getResource(caminho));
imagemAux = icone.getImage();
icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
rotulo.setIcon(icone);
} catch (Exception err) {
System.out.println("erro " + err.getLocalizedMessage());
}pnDireita.add(pnE1, BorderLayout.NORTH);
pnE1.add(rotulo);
pnDireita.add(pnE2, BorderLayout.CENTER);
pnE2.add(btAbrirImagem);
pnDireita.add(pnE3, BorderLayout.SOUTH);
pnE3.add(tfCaminho);
pnEsquerda.add(pnNorte, BorderLayout.NORTH);
pnEsquerda.add(pnCentro, BorderLayout.CENTER);
pnEsquerda.add(pnSul, BorderLayout.SOUTH);pnNorte.add(lbIdMotorista);
pnNorte.add(tfIdMotorista);
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
btAbrirImagem.setEnabled(false);
tfCaminho.setEditable(false);
pnCentro.add(lbNomeMotorista);
pnCentro.add(tfNomeMotorista);
pnCentro.add(lbTelefoneMotorista);
pnCentro.add(tfTelefoneMotorista);
pnCentro.add(lbEnderecoMotorista);
pnCentro.add(tfEnderecoMotorista);
pnSul.setBackground(Color.red);
scroll.add(jTextArea);
pnSul.add(scroll);
tfCaminho.setEditable(false);
tfNomeMotorista.setEditable(false);
tfTelefoneMotorista.setEditable(false);
tfEnderecoMotorista.setEditable(false);
btnRetrieve.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
tfIdMotorista.setBackground(Color.white);
jTextArea.setText("");
motorista = new Motorista();
int identificador = Integer.valueOf(tfIdMotorista.getText());
motorista.setIdMotorista(identificador);
motorista = daoMotorista.obter(motorista.getIdMotorista());
if (motorista == null) {
pnNorte.setBackground(Color.red);
tfCaminho.setText("");
tfNomeMotorista.setText("");
tfTelefoneMotorista.setText("");
tfEnderecoMotorista.setText("");
btnCreate.setVisible(true);
} else {
pnNorte.setBackground(Color.green);
caminho = motorista.getCaminho();
tfCaminho.setText(caminho);
icone = new ImageIcon(caminho);
imagemAux = icone.getImage();
icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
rotulo.setIcon(icone);
tfNomeMotorista.setText(motorista.getNomeMotorista());
tfTelefoneMotorista.setText(motorista.getTelefoneMotorista());
tfEnderecoMotorista.setText(motorista.getEnderecoMotorista());
btnUpdate.setVisible(true);
btnDelete.setVisible(true);
btnCreate.setVisible(false);
}
btAbrirImagem.setEnabled(false);
tfIdMotorista.setEditable(false);
tfNomeMotorista.setEditable(false);
tfTelefoneMotorista.setEditable(false);
tfEnderecoMotorista.setEditable(false);
tfIdMotorista.selectAll();
} catch (Exception erro) {
pnNorte.setBackground(Color.yellow);
tfIdMotorista.requestFocus();
tfIdMotorista.setBackground(Color.red);
jTextArea.setText("Erro... \n");
jTextArea.append(erro.getMessage());
}
}
});
btnCreate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
tfIdMotorista.setEditable(false);
tfNomeMotorista.requestFocus();
btnCreate.setVisible(false);
btnSave.setVisible(true);
qualAcao = "incluir";
motorista = new Motorista();
tfNomeMotorista.setEditable(true);
tfTelefoneMotorista.setEditable(true);
tfEnderecoMotorista.setEditable(true);
tfIdMotorista.setEditable(false);
btAbrirImagem.setEnabled(true);
}
});
btnSave.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
motorista = new Motorista();
motorista.setIdMotorista(Integer.valueOf(tfIdMotorista.getText()));
motorista.setNomeMotorista(tfNomeMotorista.getText());
motorista.setTelefoneMotorista(tfTelefoneMotorista.getText());
motorista.setEnderecoMotorista(tfEnderecoMotorista.getText());
caminho = tfCaminho.getText();
motorista.setCaminho(caminho);
caminho = "";
icone = new ImageIcon(caminho);
rotulo.setIcon(icone);
if (qualAcao.equals("incluir")) {
daoMotorista.inserir(motorista);
} else {
daoMotorista.atualizar(motorista);
}
tfIdMotorista.setEditable(true);
tfIdMotorista.requestFocus();
tfNomeMotorista.setText("");
tfTelefoneMotorista.setText("");
tfEnderecoMotorista.setText("");
tfCaminho.setText("");
btnSave.setVisible(false)
;pnNorte.setBackground(Color.green);
tfNomeMotorista.setEditable(false);
tfTelefoneMotorista.setEditable(false);
tfEnderecoMotorista.setEditable(false);
btAbrirImagem.setEnabled(false);
} catch (Exception erro){
jTextArea.append("Erro............");
tfIdMotorista.setEditable(true);
pnNorte.setBackground(Color.red); 
}
}
});
btnUpdate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
btAbrirImagem.setEnabled(true);
tfNomeMotorista.requestFocus();
btnSave.setVisible(true);
qualAcao = "editar";
tfNomeMotorista.setEditable(true);
tfTelefoneMotorista.setEditable(true);
tfEnderecoMotorista.setEditable(true);
}
});
btnDelete.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
"Confirma a exclusão do registro <ID = " + motorista.getIdMotorista() + ">?", "Confirm",
JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
daoMotorista.remover(motorista);
tfIdMotorista.requestFocus();
tfNomeMotorista.setText("");
tfTelefoneMotorista.setText("");
tfEnderecoMotorista.setText("");
String caminho = "";

icone = new ImageIcon(caminho);
rotulo.setIcon(icone);

tfCaminho.setText("");
tfIdMotorista.setEditable(true);
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
}
}
});
btnList.addActionListener(new ActionListener() {
@Override
 public void actionPerformed(ActionEvent e) {
GUIListagemMotorista guiListagem = new GUIListagemMotorista(daoMotorista.list());
}
});
setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
dispose();
}
});
btAbrirImagem.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFileChooser fc = new JFileChooser();
fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
if (fc.showOpenDialog(pnDireita) == JFileChooser.APPROVE_OPTION) {
File img = fc.getSelectedFile();
String caminho = fc.getSelectedFile().getAbsolutePath();
try {
tfCaminho.setText(caminho);
icone = new javax.swing.ImageIcon(img.getAbsolutePath());
imagemAux = icone.getImage();
icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
rotulo.setIcon(icone);
} catch (Exception ex) {
System.out.println("Erro: " + ex.getMessage());
}
}
}
});
tfIdMotorista.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoMotorista.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfIdMotorista.setText(aux[0]);
btnRetrieve.doClick();

} else {
tfIdMotorista.requestFocus();tfIdMotorista.selectAll();}
}
}
});
CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
setVisible(true);
}
public static void main(String[] args) {
GUIMotorista guiMotorista = new GUIMotorista();
}
}
