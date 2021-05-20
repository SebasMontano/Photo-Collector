package ui;

import java.util.Scanner;


import model.PhotoCollector;

public class Main {
	
	private PhotoCollector collector;
	private Scanner sc;
	
	
	public Main() {
		collector= new PhotoCollector();
		sc= new Scanner(System.in);
	}
	public static void main(String [] args) {
		
		System.out.println("Iniciando la aplicación");
		
		Main ppal= new Main();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
		
	}
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Menú principal, seleccione una opción\n" +
				"(1) Para crear, editar o eliminar un álbum \n" +
				"(2) Para mostrar la información de los albums en la colección \n"+
				"(3) Para agregar una foto a un álbum\n"+
				"(4) Para editar una foto\n" +  
				"(0) Para salir"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			showMenuAlbum() ;
			break;
		case 2:
			System.out.println(collector.showAlbums());
			break;
	
		case 3:
			addPhotoInAlbum();
			break;

		case 4:
			editPhotoInAlbum();
			break;
		
		default:
			System.out.println("Error, opción no válida");
		
		}
	}

	private void editPhotoInAlbum() {
		
		
	}
	private void addPhotoInAlbum() {
		
		
	}

	private void showMenuAlbum() {
		int option=0;
		System.out.println(
				"Menú Album\n" +
				"(1) Para crear un álbum\n" +
				"(2) Para editar un álbum\n"+
				"(3) Para eliminar un álbum\n"+
				"(0) Para volver"
				);
		option= sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		case 1:
			createAlbum();
			break;
		case 2:
			editAlbum();
			break;
		case 3: 
			deleteAlbum();
			break;
		
		}
		
	}
	private void deleteAlbum()
	{
		String tit;
		System.out.print("Ingrese el titulo del album que desea eliminar: ");
		tit = sc.nextLine();
		sc.nextLine();

		if(tit != null && tit != "")
		{
			collector.deleteAlbum(tit);
		}
		else
			System.out.println("No se puede eliminar un album sin saber su titulo");

	}
	private void editAlbum()
	{
		String tit, modTit, aType;
		int numPages, numPics;

		System.out.println("Ingrese el titulo del album que desea editar:");
		tit = sc.nextLine();

		System.out.println("Ingrese el nuevo titulo que desea ponerle:");
		modTit = sc.nextLine();

		System.out.println("Ingrese el nuevo numero de paginas que quiere que tenga este album:");
		numPages = sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese el nuevo numero de fotos por pagina que quiere que tenga el album:");
		numPics = sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese el nuevo tipo de album que quiere que tenga el album (DIGITAL, ANALOGIC)");
		aType = sc.nextLine();
		aType = aType.toUpperCase();

		if(tit != null && tit != "" && modTit != "" && modTit != null)
		{
			collector.editAlbum(tit, modTit, numPages, numPics, aType);
		}
	}
	private void createAlbum() {
		if(collector.hasAlbums()) {
			String tit, aType;
			int numPages, numPics;
			System.out.println("Digite los datos del album a crear ");
			System.out.println("Título del album: ");
			tit = sc.nextLine();
			
			if(!collector.findAlbum(tit)) {
				System.out.println("Número de páginas del album: ");
				numPages = sc.nextInt();
				sc.nextLine();
				System.out.println("Cantidad de fotos por página del album: ");
				numPics = sc.nextInt();
				sc.nextLine();
				System.out.println("Tipo del album (DIGITAL, ANALOGIC): ");
				aType = sc.nextLine();
				aType= aType.toUpperCase();
				
				collector.addAlbum(tit, numPages, numPics, aType);
				
				System.out.println("El album \""+ tit +"\" ha sido creado con éxito\n");
				
			}else {
				System.out.println("Ya existe en la colección un album con título "+ tit);
			}
		}else {
			System.out.println("No puede crearse el álbum porque se llegó al límite\n");
		}
		
	}

	


}
