package Mundo;

import java.io.File;

public class Directorios {

	
	/*
	 * Ruta del directorio
	 */
	public String laRuta;
	
	
	/*
	 * Donde empieza a buscar 
	 */
	public static final String INICIO = "C:" + File.separator;
	
	// METODOS
	//Constructor 
	
	/**
	 * Donde empieza a buscar
	 */
	public Directorios()
	{
		laRuta = INICIO;
	}
	
	/**
	 * ruta de si mismo
	 * @return
	 */
	
	public Directorios(String laRuta)
	{
		this.laRuta = laRuta;
	}
	
	
	// GETTERS
	
	/*
	 * Nombre del directorio
	 */
	 public String darName( )
	    {
		 // Si es raiz comienza en blanco
	        if( estaRaiz( ) )
	            return "";
	        else
	        {
	            // ultima posicion del separador de directorios 
	            int pos = laRuta.lastIndexOf( File.separator );

                    // NOMBRE DEL DIRECTORIO
	            return laRuta.substring( pos + 1 );
	        }
	    }
	 
	public String darLaRuta() {
		// TODO Auto-generated method stub
	 return laRuta;
	}

 /*
  * Sube nivel de la jerarquía de directorio, si no es raiz
  */

	public void subirLevel()
	{
		// Diferente a la raiz
		 if( !estaRaiz( ) )
	        {
	            int posicion = laRuta.lastIndexOf( File.separator );
	            laRuta = laRuta.substring( 0, posicion );
	            if( laRuta.indexOf( File.separator ) == -1 )
	            {
	            	laRuta += File.separator;
	            }
	        }
	}
	 /*
	  * El directorio corresponde a raiz del sistema  true si es raiz
	  */
	private boolean estaRaiz() {
		// TODO Auto-generated method stub
		return  laRuta.equals(INICIO);
		}
	 
	public String toString()
	{
		return darName();
	}
	
}
