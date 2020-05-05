package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PBusqueda extends JPanel implements ActionListener {
  private static final String SEARCH = "Search";
  
  private InterfazSistema sistema;
  
  private JList lisArch;
  
  private JScrollPane scroll;
  
  private JTextField txtBusqueda;
  
  private JButton btnBuscar;
  
  public PBusqueda(InterfazSistema sistema) {
    this.sistema = sistema;
    setBorder(new TitledBorder("Buscar"));
    setLayout(new BorderLayout());
    this.lisArch = new JList();
    this.lisArch.setBackground(Color.BLACK);
    this.lisArch.setForeground(Color.white);
    this.scroll = new JScrollPane(this.lisArch);
    this.scroll.setPreferredSize(new Dimension(250, 250));
    add(this.scroll, "Center");
    JPanel panelBusqueda = new JPanel();
    panelBusqueda.setBorder(new TitledBorder("Palabra"));
    panelBusqueda.setLayout(new BorderLayout());
    add(panelBusqueda, "South");
    this.btnBuscar = new JButton("Buscar");
    this.btnBuscar.setActionCommand("Search");
    this.btnBuscar.addActionListener(this);
    this.btnBuscar.setBackground(Color.WHITE);
    panelBusqueda.add(this.btnBuscar, "East");
    this.txtBusqueda = new JTextField();
    Font fuente = new Font("Calibri", 15, 15);
    this.txtBusqueda.setFont(fuente);
    this.txtBusqueda.setBackground(Color.BLACK);
    this.txtBusqueda.setForeground(Color.WHITE);
    this.txtBusqueda.setDisabledTextColor(Color.RED);
    this.txtBusqueda.setColumns(25);
    panelBusqueda.add(this.txtBusqueda, "Center");
  }
  
  public void refrescar(ArrayList arch) {
    if (arch.size() > 0) {
      this.lisArch.setListData(arch.toArray());
    } else {
      this.lisArch.setListData(new Object[] { "Ningun archivo encontrado..." });
    } 
  }
  
  public void limpiar() {
    this.lisArch.setListData(new Object[0]);
    this.txtBusqueda.setText("");
  }
  
  public void actionPerformed(ActionEvent e) {
    String criterio = this.txtBusqueda.getText();
    if (criterio.indexOf(' ') != -1) {
      JOptionPane.showMessageDialog(this, "No debe incluir espacios", "Error", 0);
    } else {
      this.sistema.buscar(criterio);
    } }
  }