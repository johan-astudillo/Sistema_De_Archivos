package Mundo;

import java.io.File;
import java.io.IOException;

// importamos el ArrayList

import java.util.ArrayList;





public class Sistema {

	// ATRIBUTOS

	/**
	 * Archivos en el sistema de archivos
	 */

	private ArrayList arch;

	/**
	 * Los subDirectios en el sistema de archivos
	 */

	private ArrayList subDirec;

	/*
	 * los directios para desplegar los archivos
	 */
	private Directorios dirActual;

	// METODOS
	// CONSTRUCTOR

	/*
	 * Constructor
	 */
	public Sistema() {
		dirActual = new Directorios();
		actualizarInfo();
	}

	public Sistema(String nameDirectorio) {
		// directorio actual con su ruta especificada
		dirActual = new Directorios(nameDirectorio);
		actualizarInfo();
	}

	
	/*
	 * Dice cual es el estado de la ruta del directorio
	 */
	private void actualizarInfo() {
		// TODO Auto-generated method stub
		
		 subDirec = new ArrayList( );
	        arch = new ArrayList( );

	        // Saca la lista de archivos de directorio
	        File directorio = new File( dirActual.darLaRuta() );
	        File[] elementos = directorio.listFiles( );
	        if( elementos != null )
	        {
	            for( int i = 0; i < elementos.length; i++ )
	            {
	                // Verifica si es directorio o si es archivo
	                if( elementos[ i ].isDirectory( ) )
	                {
	                	subDirec.add( new Directorios( elementos[ i ].getAbsolutePath( ) ) );
	                }
	                else if( elementos[ i ].isFile( ) )
	                {
	                	arch.add( new Archivos( elementos[ i ].getAbsolutePath( ) ) );
	                }
	            }
	        }
		
	}
	
	/**
	 * Sube de nivel de directorio para retroceder al directorio padre
	 * 
	 */
	public void atrasDirect()
	{
		dirActual.subirLevel();
		
		actualizarInfo();
	}
	/*
	 * El directorio especificado cambia a ser el actual 
	 */
	public void irADirectorio(int numeroDeDirectorio) {
		
		// acceso a directorio
		dirActual = (Directorios)subDirec.get(numeroDeDirectorio);
		
		actualizarInfo();
	}
	
	/**
	 * Busca un archivo por su nombre
	 * @return el archivo buscado
	 */
	
	public Archivos buscarElArchivo(String name)
	{
		for(int i = 0; i < arch.size(); i++)
		{
			Archivos elarchivo = (Archivos)arch.get(i);
		   if(elarchivo.darNombreArc().equals(name))
			   return elarchivo;
		}
		return null;
	}
	
	/**
	 * Creamos un nuevo archivo tipo texto, si el archivo ya existe devuelve el existente
     * Si no tiene acceso para crear archivo lanza error
	 */
	public Archivos crearUnArchivo(String name) throws IOException
	{
		Archivos elArchivo = buscarElArchivo(name);
		// si el archivo no existe crea uno nuevp
		if(elArchivo == null)
		{
			File file = new File (dirActual.darLaRuta() + File.separator + name);
			file.createNewFile();
			actualizarInfo();
		}
		return buscarElArchivo(name);
	}
	
   /*
    * busqueda por palabra 
    */
	public ArrayList buscarPorPrefijo(String prefijo)
	{
		ArrayList response = new ArrayList();
        
		// recorre archivos
		for(int i = 0; i < arch.size(); i++)
		{
			// try catch de condiciones
			try
            {
                Archivos elArchivo = ( Archivos )arch.get( i );
                if( elArchivo.esTextoArch( ) && elArchivo.contienePrefijo( prefijo ) )
                	response.add( arch );
            }
			// catch no se hace nada 
            catch( IOException e )
            {
                // En caso de error de lectura no se hace nada, simplemente no se incluye
            }
        }
        // Devuelve los archivos encontrados
        return response;
		
	}
	
	
	// GETTERS 
	/*
	 * Ruta del directorio actual
	 */
	public  String darRutaActual()
	{
		return dirActual.darLaRuta();
	}
	
	/*
	 * Los archivos del directorio
	 */
	public Archivos[] darLosArchivos() {
		Archivos[] elArchivo = new Archivos[arch.size( )];
		arch.toArray(elArchivo);
		return elArchivo;
	}
	
	/*
	 * Da los subdirectorios 
	 */
	public Directorios[] darSubDir()
	{
		Directorios[] subDirectorios = new Directorios[subDirec.size()];
		subDirec.toArray(subDirectorios);
		return subDirectorios;
	}
}
