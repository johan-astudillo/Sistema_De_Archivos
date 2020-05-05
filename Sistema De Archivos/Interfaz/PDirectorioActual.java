package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PDirectorioActual extends JPanel implements ActionListener {
	
	// Constantes
	
	private static final String ATRAS = "Atras";

	// ATRIBUTES
	private InterfazSistema sistema;
	
	private JTextField txtDir;
	
	private JButton btnAtras;
	
	// Constructor
	public PDirectorioActual (InterfazSistema sistema)
	{
	    this.sistema = sistema;
		
		setBorder(new TitledBorder("Directorio en que se encuentra"));
		setLayout(new BorderLayout());
		
		// ELEMENTOS 
		txtDir = new JTextField();
		
		txtDir.setBackground(Color.BLACK);
	    txtDir.setForeground(Color.WHITE);
		
	    
	    txtDir.setColumns(60);
		txtDir.setEditable(false);
		add(txtDir, BorderLayout.CENTER);
		
		// boton
		btnAtras = new JButton("<<");
		btnAtras.setActionCommand(ATRAS);
		btnAtras.addActionListener(this);
		add(btnAtras, BorderLayout.EAST);
	}

	public void refrescar(String rutaAct)
	{
		txtDir.setText(rutaAct);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		
		if(ATRAS.equals(cmd))
			
			sistema.atras();
		
	}
	
	
	
}
