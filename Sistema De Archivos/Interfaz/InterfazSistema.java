package Interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Mundo.Archivos;
import Mundo.Sistema;





public class InterfazSistema  extends javax.swing.JFrame{

	/*
	 * Llama a la clase principal
	 */
	private Sistema sistema;
	
	private PImagen pImagen;
	
	private PArchivos pArchivos;
	
	private PDirectorios pDirectorios;
	
	private PDirectorioActual pDirectorioActual;
	
	private  PBusqueda pBusqueda;
	
	private  PNewArchivo pNewArchivo;
	
	private PExtension pExtension;
	
	
	public InterfazSistema()
	{
		 // Crea la clase principal
        sistema = new Sistema( );

        // Construye la forma
        setLayout( new BorderLayout( ) );
       
        //Imagen taza de cage
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                ("imagenes/icono.png")));
        
        // dimensiones
        setSize( 800, 650 );
        setTitle( "Sistema de archivos - Sistemas Operativos" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Panel Imagen
        pImagen = new PImagen();
        add( pImagen, BorderLayout.NORTH );

        
        // Panel izquierdo
       JPanel pizquierdo = new JPanel();
       pizquierdo.setLayout(new BorderLayout());
       add(pizquierdo, BorderLayout.WEST);
       //panel de arriba izquierdo
       pDirectorios = new PDirectorios(this );
       pizquierdo.add( pDirectorios, BorderLayout.NORTH );
      //panel de abajo izquierdo       
       pArchivos = new PArchivos(this );
       pizquierdo.add( pArchivos, BorderLayout.CENTER );
        
       // panel center
       
       JPanel pCenter = new JPanel();
       pCenter.setLayout(new BorderLayout());
       add(pCenter, BorderLayout.CENTER);
       // panel norte centro
       pDirectorioActual = new PDirectorioActual(this);
       pCenter.add(pDirectorioActual, BorderLayout.NORTH);
       // panel WEST center
       pBusqueda = new PBusqueda(this);
       pCenter.add(pBusqueda, BorderLayout.CENTER);
       // PANEL EAST CENTER
       pNewArchivo = new PNewArchivo(this);
       pCenter.add(pNewArchivo, BorderLayout.EAST);
        
       setLocationRelativeTo(null);
        setResizable(false);
        
       
		
	}
	
	// PROGRAMA
	public static void main(String[] args)
	{
		InterfazSistema elSistema = new InterfazSistema();
		elSistema.setVisible(true);
	}


/*
 * Navega en el subDirectorio
 */
	public void navegar(int indice) {
		// TODO Auto-generated method stub
		sistema.irADirectorio(indice);
		refrescar();
	}


	
	
	

	public void refrescar() {
	pDirectorioActual.refrescar(sistema.darRutaActual());
	pDirectorios.refrescar(sistema.darSubDir());
	pArchivos.refrescar(sistema.darLosArchivos());
     pBusqueda.limpiar();
	
	}

	public void verInfoArchivo(Archivos archivo) {
		// TODO Auto-generated method stub
		
	     
	}

	public void atras() {
		// TODO Auto-generated method stub
		sistema.atrasDirect();
		refrescar();

	}
	

	public void buscar(String crit) {
		ArrayList resultado = sistema.buscarPorPrefijo(crit);
		pBusqueda.refrescar(resultado);

	}

	
	public void crearArchivo(String name, String text) {
		try {
			Archivos arch = sistema.crearUnArchivo(name);
			arch.escribirEnArchivo(text);
			pNewArchivo.limpiar();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		pArchivos.refrescar(sistema.darLosArchivos());
	}
	
	
	public void verInfoArch(Archivos arch)
	{
	 if(arch != null)
	 {
		 DialogoArchivo dialogo = new DialogoArchivo(this, arch);
		 dialogo.setVisible(true);
	 }
	}

}
