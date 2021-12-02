package actividad4.criptografia;

import actividad4.criptografiamo.modelo.MenuEncriptacion;

public class Main {

	public static void main(String[] args) {
	
		MenuEncriptacion menu = new MenuEncriptacion();
		String eleccion = null;
		
		do {
			eleccion = menu.menu();
		}while(!eleccion.equals("1"));
		
		System.out.println("Fin del programa!!");
	}

}
