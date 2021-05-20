package model;

public class Album {
	
	private String title;
	private int numPages;
	private int picsPerPage;
	private AlbumType type;
	
	// Relationships

	private Photo [] photos;

	// Builder

	public Album(String title, int numPages, int picsPerPage, AlbumType type)
	{
		this.title = title;
		this.numPages = numPages;
		this.picsPerPage = picsPerPage;
		this.type = type;
	}
	
	// Getters & Setters

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setNumPages(int numPages)
	{
		this.numPages = numPages;
	}

	public void setNumPics(int picsPerPage)
	{
		this.picsPerPage = picsPerPage;
	}

	public void setAlbumType(AlbumType type)
	{
		this.type = type;
	}

	// Methods

	public String show()
	{
		String showAlbum = "";

		showAlbum += "Album de titulo: " + title + "\n" +
					 "Numero de paginas: " + numPages + "\n" +
					 "Fotos por pagina: " + picsPerPage + "\n" +
					 "Tipo de album: " + String.valueOf(type) + "\n" +
					 "\n";
		return showAlbum;
	}
}
