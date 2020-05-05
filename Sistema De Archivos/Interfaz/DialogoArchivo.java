package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

import Mundo.Archivos;

public class DialogoArchivo extends JDialog{

	
	private PInfoArchivo pInfoArchivo;
	
	public DialogoArchivo(JFrame sistema, Archivos arch) {
	
		super(sistema, true);
	setTitle("Archivo" + arch.darNombreArc());
	setLayout(new BorderLayout());
	
	pInfoArchivo = new PInfoArchivo(arch);
	add(pInfoArchivo, BorderLayout.CENTER);
	
	pack();
	setLocationRelativeTo(sistema);
		
	}

}
