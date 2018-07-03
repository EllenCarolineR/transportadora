/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import tools.CentroDoMonitorMaior;

public class GUIMenu extends JFrame {

    ImageIcon img = new ImageIcon(getClass().getResource("/icones/caminhao.jpg"));
    JLabel logo = new JLabel(img);

    public GUIMenu() {
        setTitle("Menu Example");
        JMenuBar menuBar = new JMenuBar();
        Container cp = getContentPane();
        cp = getContentPane();
        cp.add(logo);
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Cavalo");
        menuBar.add(fileMenu);
        JMenu fileMenu2 = new JMenu("Carreta");
        menuBar.add(fileMenu2);
        JMenu fileMenu3 = new JMenu("Motorista");
        menuBar.add(fileMenu3);
        JMenu fileMenu4 = new JMenu("Caminhao");
        menuBar.add(fileMenu4);
        JMenu fileMenu5 = new JMenu("Transporte");
        menuBar.add(fileMenu5);

        JMenuItem cavalo = new JMenuItem("GUICavalo");
        JMenuItem carreta = new JMenuItem("GUICarreta");
        JMenuItem motorista = new JMenuItem("GUIMotorista");
        JMenuItem caminhao = new JMenuItem("GUICaminhao");
        JMenuItem transporte = new JMenuItem("GUITransporte");

        fileMenu.add(cavalo);

        fileMenu.addSeparator();
        fileMenu2.add(carreta);
        fileMenu.addSeparator();
        fileMenu3.add(motorista);
        fileMenu3.addSeparator();
        fileMenu4.add(caminhao);
        fileMenu4.addSeparator();
        fileMenu5.add(transporte);
        fileMenu5.addSeparator();
        setVisible(true);

        cavalo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICavalo guiCavalo = new GUICavalo();
            }
        });
        carreta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICarreta guiCarreta = new GUICarreta();
            }
        });
        motorista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIMotorista guiMotorista = new GUIMotorista();
            }
        });
         caminhao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICaminhao guiCaminhao = new GUICaminhao();
            }
        });
          transporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUITransporte guiTransporte = new GUITransporte();
            }
        });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        pack();
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
    }
}
