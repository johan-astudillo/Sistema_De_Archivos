package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PNewArchivo extends JPanel implements ActionListener {
	  private static final String CREAR = "Crear";
	  
	  private InterfazSistema sistema;
	  
	  private JTextArea txtText;
	  
	  private JScrollPane scroll;
	  
	  private JTextField txtNombre;
	  
	  private JButton btnCrear;
	  
	  private JList lisArch;
	  
	  public PNewArchivo(InterfazSistema sistema) {
	    this.sistema = sistema;
	    setBorder(new TitledBorder("Crear nuevo archivo"));
	    setLayout(new BorderLayout());
	    this.txtText = new JTextArea();
	    this.txtText.setLineWrap(true);
	    this.txtText.setWrapStyleWord(true);
	    this.lisArch = new JList();
	    this.lisArch.setBackground(Color.BLACK);
	    this.lisArch.setForeground(Color.white);
	    this.scroll = new JScrollPane(this.lisArch);
	    this.scroll.setPreferredSize(new Dimension(250, 250));
	    add(this.scroll, "Center");
	    JPanel panelBusqueda = new JPanel();
	    panelBusqueda.setBorder(new TitledBorder("Nombre new Archivo"));
	    panelBusqueda.setLayout(new BorderLayout());
	    add(panelBusqueda, "South");
	    this.btnCrear = new JButton("Crear");
	    this.btnCrear.setActionCommand("Crear");
	    this.btnCrear.addActionListener(this);
	    this.btnCrear.setBackground(Color.WHITE);
	    panelBusqueda.add(this.btnCrear, "East");
	    this.txtNombre = new JTextField();
	    this.txtNombre.setColumns(14);
	    Font fuente = new Font("Calibri", 15, 15);
	    this.txtNombre.setFont(fuente);
	    this.txtNombre.setBackground(Color.BLACK);
	    this.txtNombre.setForeground(Color.WHITE);
	    this.txtNombre.setDisabledTextColor(Color.RED);
	    panelBusqueda.add(this.txtNombre, "Center");
	  }
	  
	  public void limpiar() {
	    this.txtNombre.setText("");
	    this.txtText.setText("");
	  }
	  
	  public void actionPerformed(ActionEvent e) {
	    String cmd = e.getActionCommand();
	    if ("Crear".equals(cmd))
	      this.sistema.crearArchivo(this.txtNombre.getText(), this.txtText.getText()); 
	  }
	}
