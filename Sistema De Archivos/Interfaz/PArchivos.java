package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Mundo.Archivos;
import Mundo.Directorios;


public class PArchivos extends JPanel implements ListSelectionListener{

	private InterfazSistema sistema;
	
	private JList lisArch;
	
	private JScrollPane scroll;
	

	
	public PArchivos(InterfazSistema sistema)
	{
		this.sistema = sistema;
		
		setBorder(new TitledBorder("Lista de Archivos"));
		setLayout(new BorderLayout());
		
		
		// ELEMENTOS 
		lisArch = new JList();
		lisArch.addListSelectionListener(this);
		
		lisArch.setBackground(Color.BLACK);
	    lisArch.setForeground(Color.white);
		
		scroll = new JScrollPane(lisArch);
		scroll.setPreferredSize(new Dimension(250, 200));
		add(scroll, BorderLayout.CENTER);
		setPreferredSize(new Dimension(300, 250));
			
	}
	
	
	public void refrescar(Archivos[] arch)
	{
		lisArch.setListData(arch);
	}
	
	public Archivos darArchivoSelec()
	{
		return (Archivos) lisArch.getSelectedValue();
	}
	
	
	 public void valueChanged( ListSelectionEvent event )
	    {
	        // Selección en la lista de archivos
	        Archivos archivo = darArchivoSelec();
	        // Muestra el diálogo del archivo
	        sistema.verInfoArchivo(archivo);
	    }
	
}
