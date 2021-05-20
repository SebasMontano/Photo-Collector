package model;

public class PhotoCollector {
	public final static int MAX_ALBUMS= 10;
	
	private Album[] albums;
	private int numAlbums;
	
	
	/**
	 * Método constructor se inicializa el arreglo de Albums y 
	 * un atributo para llevar la cuenta de los albums en la colección
	 */
	public PhotoCollector() {
		albums = new Album[MAX_ALBUMS];
		numAlbums = 0;
		
	}
	
	public boolean hasAlbums() {
		return numAlbums < MAX_ALBUMS;
	}

	/**
	 * Método que agrega un nuevo album a la colección
	 * pre: el arreglo albums está inicializado, no hay albums con el mismo título
	 * pos: numAlbums++, albums tiene un nuevo objeto album en la primera posición vacía
	 * @param tit, el título del album, tit !=null tit!= ""
	 * @param numPages el número de páginas de un album
	 * @param numPics el número de fotos por página
	 * @param type es el tipo de Album
	 */
	public void addAlbum(String tit, int numPages, int numPics, String type)
	{	
		AlbumType aType= AlbumType.valueOf(type);
		if(tit != null && tit != "")
		{
			albums[numAlbums] = new Album(tit, numPages, numPics, aType);
			numAlbums++;
		}
		else
			System.out.println("Lo sentimos no se puede crear un album sin un titulo");
	}

	/**
	 * Método que informa si ya existe un álbum con el mismo título
	 * @param title el título a buscar
	 * @return found, es true si existe un album con el título, false en el caso contrario. 
	 */
	public boolean findAlbum(String title) {
		boolean found=false;
		if(numAlbums > 0)
		{
			for(int i = 0;i < numAlbums;i++)
			{
				if(albums[i].getTitle() == title)
					found = true;
			}
		}
		return found;
	}

	/**
	 * Método que retorna la información de todos los albums en la colección
	 * @return out, un String con la info de todos los albums
	 */
	public String showAlbums()
	{
		String out="";
		if(numAlbums > 0)
		{
			for(int i = 0;i < numAlbums;i++)
			{
				out += albums[i].show();
			}
		}
		else
			System.out.println("No hay albums para mostrar");
		return out;
	}
	
	/**
	 * Método que modifica la información de un album 
	 * pre: el arreglo albums está inicializado, el album existe en la colección
	 * pos: Se modificó la información del album
	 * @param tit, el título del album, tit !=null tit!= ""
	 * @param numPages el número de páginas de un album
	 * @param numPics el número de fotos por página
	 * @param type es el tipo de Album
	 */
	public void editAlbum(String tit, String newTit, int numPages, int numPics, String type)
	{
		AlbumType aType = AlbumType.valueOf(type);

		for(int i = 0;i < numAlbums;i++)
		{
			if(tit == albums[i].getTitle())
			{
				albums[i].setTitle(newTit);
				albums[i].setNumPages(numPages);
				albums[i].setNumPics(numPics);
				albums[i].setAlbumType(aType);
			}
		}
	}
	
	/**
	 * Método que borra un album de la colección 
	 * pre: el arreglo albums está inicializado, el album existe en la colección
	 * pos: numAlbums--, la pocisión en la que estaba el album ahora está vacía.
	 * @param tit, el título del album, tit !=null tit!= ""
	 */
	public void deleteAlbum(String tit)
	{
		boolean hasEliminatedAlbum = false;

		for(int i = 0;i < numAlbums;i++)
		{
			if(tit == albums[i].getTitle())
			{
				albums[i] = null;
				hasEliminatedAlbum = true;
				System.out.println("El album ha sido eliminado con exito");
			}
		}

		if(!hasEliminatedAlbum)
		{
			System.out.println("No se ha podido encontrar el album que quiso eliminar");
		}
	}

}
