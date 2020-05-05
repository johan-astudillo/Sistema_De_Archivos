package Mundo;

import java.io.BufferedReader;
// las importaciones
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Archivos {

	/*
	 * el Archivo en el que nos encontramos
	 */
	private File elArch;
	
	// METODOS
	// Constructor
	
	/**
	 * Constructor del archivo
	 * @param la ruta se especifica con una cadena 
	 */
	public Archivos (String ruta)
	{
	  elArch = new File(ruta);
	}
	
	// Demas metodos
	/**
	 * Indica si el archivo es un texto si es falso entonces menciona lo contrario
	 * 
	 */
    public boolean esTextoArch() 
    {
    	String name = elArch.getName();
    	return name.toUpperCase().endsWith(".TXT");
    }
	
    /**
     * Escribir en archivo algun contenido
     * @param conte el contenido
     * @throws IOException lanza error al escribir un archivo
     */
    public void escribirEnArchivo(String conte) throws IOException
    {
     // printwriter para escribir en dicho contenido
    	PrintWriter escribir = new PrintWriter(elArch);
    	escribir.println(conte);
    }
	
    /**
     * La palabra que se escribio encuentra el prefijo especificado como el archivo empieza
     * @param el  prefijo
     * @return true si contiene prefijo
     * @throws IOException error de lectura
     */
    
    public boolean contienePrefijo( String estePrefi ) throws IOException
    {
        // no lo encuentra empezando
        boolean contiene = false;

        // lee el archivo utilizando un FileReader 
        FileReader reader = new FileReader( elArch );
        
        // Bufferedreader para leer por lineas 
        BufferedReader lector = new BufferedReader( reader );

        // lee cada linea por archivo
        String linea = lector.readLine( );
        while( linea != null && !contiene )
        {
            contiene = lineaContenedora( linea, estePrefi );
            linea = lector.readLine( );
        }

        // Cierra los lectores y devuelve el resultado
        lector.close( );
        reader.close( );
        return contiene;
    }
    
    
    
	/**
	 * Linea especificada contiene un prefijo que llega como parametro
	 */
	private boolean lineaContenedora(String linea, String estePrefi) {
	 
		// Primero empezamos limpiando dicha linea y reemplazamos por ' ' 
		linea = limpiarLaLinea(linea);
		
		String[] laPala = linea.split(" ");
		
		
		// buscamos palabra por palabra
		   for( int i = 0; i < laPala.length; i++ )
	        {
	            if( laPala[ i ].toLowerCase( ).startsWith( estePrefi.toLowerCase( ) ) )
	                return true;
	        }
	        return false;
	    }
		
		
	/**
     * posibles caracteres para reemplazar despues por un caracter vacío
     */
	private String limpiarLaLinea(String estaLinea) {
		
	  
	        // Elimina los signos de puntuación y los tabs
		estaLinea = estaLinea.replace( '\t', ' ' );
		estaLinea = estaLinea.replace( '/', ' ' );
		estaLinea = estaLinea.replace( '.', ' ' );
		estaLinea = estaLinea.replace( ',', ' ' );
		estaLinea = estaLinea.replace( ':', ' ' );
		estaLinea = estaLinea.replace( ';', ' ' );
		estaLinea = estaLinea.replace( '!', ' ' );
		estaLinea = estaLinea.replace( '\"', ' ' );
		estaLinea = estaLinea.replace( '*', ' ' );
		estaLinea = estaLinea.replace( '(', ' ' );
		estaLinea = estaLinea.replace( ')', ' ' );
		estaLinea = estaLinea.replace( '[', ' ' );
		estaLinea = estaLinea.replace( ']', ' ' );
		estaLinea = estaLinea.replace( '{', ' ' );
		estaLinea = estaLinea.replace( '}', ' ' );
		estaLinea = estaLinea.replace( '\'', ' ' );
		estaLinea = estaLinea.replace( '\\', ' ' );

	        // Devuelve la línea sin espacios iniciales/finales
	        return estaLinea.trim( );
	    }

	/*
	 * Dice cual es el tipo de dato KB kilobyte, MG Megabyte ...
	 */
	private String tipoDatos(int numVeces) {
		// TODO Auto-generated method stub
	     switch( numVeces )
	        {
	            case 0:
	                return " Bytes";
	            case 1:
	                return " KB";
	            case 2:
	                return " MB";
	            case 3:
	                return " GB";
	            case 4:
	                return " TB";
	            default:
	                return " Bytes";
	        }
	}
	

	
	//GETTERS
	/*
	 * ¿Cuanto es el archivo?
	 */
	public long darTamanioArchivo()
	{
		return elArch.length();
	}
	
	/*
	 * Devolvemos el tamaño en String del archivo en (BYTES)
	 */
	public String darTamanioCaracter() {
		
		long elTam = darTamanioArchivo();
		int numVeces = 0;
		while (elTam>1024 && numVeces <4)
		{
			elTam = elTam/1024;
             numVeces++;		
		}
		// retorna la cadena del tamaño
		return Long.toString(elTam) + tipoDatos (numVeces);
	}
	
	/**
	 * Cual es la ruta completa del archivo para que se muestre en pantalla
	 * @return
	 */
	public String darRuta()
	{
		return elArch.getAbsolutePath();
	}
	
	public String darNombreArc()
	{
		return elArch.getName();
	}

	/**
	 * Variable Date para que muestre la fecha de modificación del archivo
	 * return fecha
	 */
	
	public Date darFechaultModificacion()
	{
	
		return new Date(elArch.lastModified());	
	
	}
	
	// Metodo toString
	
	public String toString()
	{
		return darNombreArc() + "_" + darTamanioCaracter();
	}

	
}
