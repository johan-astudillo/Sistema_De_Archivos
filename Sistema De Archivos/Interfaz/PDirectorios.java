package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Mundo.Directorios;

public class PDirectorios extends JPanel implements ListSelectionListener {
	/*
	 * La interfaz
	 */
	private InterfazSistema sistema;

	/*
	 * Directorios
	 */
	private JList lisDir;
	
	/*
	 * Un scroll
	 */
	private JScrollPane scroll;

	// constructor
	public PDirectorios(InterfazSistema sistema)
	{
		this.sistema = sistema;
		
		setBorder(new TitledBorder("Lista de Sub Directorios"));
		setLayout(new BorderLayout());
		
		// ELEMENTOS 
		lisDir = new JList();
		
		lisDir.setBackground(Color.BLACK);
	    lisDir.setForeground(Color.white);
		
	    lisDir.addListSelectionListener(this);
		
		scroll = new JScrollPane(lisDir);
		scroll.setPreferredSize(new Dimension(250, 180));
		add(scroll, BorderLayout.CENTER);
		setPreferredSize(new Dimension(300, 230));
			
	}
	// metodos 
	/*
	 * Muestra nueva info
	 */
	public void refrescar(Directorios[] dir)
	{
		lisDir.setListData(dir);
	}
	
	/*
	 * cambia el valor de la lista
	 */
	public void valueChanged(ListSelectionEvent event)
	{
		// un elemento de la lista
		int i = lisDir.getSelectedIndex();
		if(i != -1) {
			sistema.navegar(i);
		}
			
	}
	
	
}