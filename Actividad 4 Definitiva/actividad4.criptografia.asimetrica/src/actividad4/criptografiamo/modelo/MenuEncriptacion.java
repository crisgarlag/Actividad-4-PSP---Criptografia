package actividad4.criptografiamo.modelo;

import java.util.InputMismatchException;
import java.util.Scanner;

import actividad4.criptografia.persistencia.EncriptacionAsimetrica;

public class MenuEncriptacion {

	private EncriptacionAsimetrica encriptacionAsimetrica;

	public MenuEncriptacion() {
		this.encriptacionAsimetrica = new EncriptacionAsimetrica();
		encriptacionAsimetrica.inicializarVariables();
	}

	public String menu() {

		Scanner sc = new Scanner(System.in);
		String eleccion;
		String mensaje;
		boolean opcionIncorrecta = false;

		System.out.println("******MENU PARA ENCRPITAR*******");
		System.out.println("1.- Salir");
		System.out.println("2.- Encriptar frase");
		System.out.println("3.- Mostrar frase encriptada");
		System.out.println("4.- Desencriptar frase");
		System.out.println("5.- Encriptar coche");
		eleccion = sc.nextLine();
		while (opcionIncorrecta == false) {
			if (eleccion.equals("1") || eleccion.equals("2") || eleccion.equals("3") || eleccion.equals("4")
					|| eleccion.equals("5")) {
				opcionIncorrecta = true;
			} else {
				System.out.println("El dato introducido es incorrecto, introduce una de las opciones validas.");
				eleccion = sc.nextLine();
			}

		}
		try {

			switch (eleccion) {
			case "2":
				System.out.println("Introduce el mensaje a encriptar");
				mensaje = sc.nextLine();
				encriptacionAsimetrica.encriptarMensaje(mensaje);
				;
				break;
			case "3":
				encriptacionAsimetrica.mostrarMensajeEncriptado();
				break;
			case "4":
				encriptacionAsimetrica.desencriptarMensaje();
				break;

			case "5":
				Coche coche = new Coche();
				System.out.println("Introduce la matricula del coche a encriptar");
				coche.setMatricula(sc.nextLine());
				System.out.println("Introduce la marca del coche a encriptar");
				coche.setMarca(sc.nextLine());
				System.out.println("Introduce el modelo del coche a encriptar");
				coche.setModelo(sc.nextLine());
				System.out.println("Introduce el precio del coche a encriptar");
				try{
					coche.setPrecio(sc.nextDouble());
				}catch(InputMismatchException e) {
					System.out.println("El precio debe ser un valor numerico.");
				}
				
				encriptacionAsimetrica.encriptarCoche(coche);
				;
				break;
			default:

			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No ha introducido ningun mensaje, previamente debe existir un mensaje encriptado");
		}

		return eleccion;

	}

}
