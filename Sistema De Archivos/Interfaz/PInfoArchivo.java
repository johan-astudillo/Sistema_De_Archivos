package Interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Mundo.Archivos;



public class PInfoArchivo extends JPanel {
	 

    private Archivos arch;

 
    private JLabel etiquetaNombre;

  
    private JLabel nombre;

    private JLabel etiquetaTamanio;

    private JLabel tamanio;

    private JLabel etiquetaFecha;

    private JLabel fecha;


    public PInfoArchivo( Archivos arch )
    {
        this.arch = arch;
        setLayout( new GridLayout( 3, 2 ) );
        setBorder( new TitledBorder( "Informaci�n Archivo" ) );

        // Nombre del archivo
        etiquetaNombre = new JLabel( "Nombre:" );
        add( etiquetaNombre );
        nombre = new JLabel( arch.darNombreArc( ) );
        add( nombre );

        // Tama�o
        etiquetaTamanio = new JLabel( "Tama�o:" );
        add( etiquetaTamanio );
        tamanio = new JLabel( arch.darTamanioCaracter( ) );
        add( tamanio );

        // Fecha Ultima Modificaci�n
        etiquetaFecha = new JLabel( "Ultima Modificaci�n:" );
        add( etiquetaFecha );
        fecha = new JLabel( arch.darFechaultModificacion( ).toString( ) );
        add( fecha );
    }
}
