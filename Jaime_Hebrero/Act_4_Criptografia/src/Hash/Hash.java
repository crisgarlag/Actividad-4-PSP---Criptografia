package Hash;


import java.security.GeneralSecurityException;
import java.util.Scanner;



import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import Menu.Menu;



public class Hash extends Menu {
	
	
	public static void main (String args[]) {
		
		System.out.println("Introduce la frase a encriptar");
		
		
		
		
		try {
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			//System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			SecretKey paloEspartano = generador.generateKey();
			//System.out.println("Paso 2: Se ha obtenido la clave");

			Cipher descifrador = Cipher.getInstance("AES");
			//System.out.println("Paso 3: Hemos obtenido el descifrador");
			
			descifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
			//System.out.println("Paso 4: Hemos configurado el descifrador");
			
			Scanner sc = new Scanner(System.in);
			String mensajeOriginal = sc.nextLine();
			
			
			byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
			byte[] bytesMensajeCifrado = descifrador.doFinal(bytesMensajeOriginal);//cifrar el mensaje original
			String mensajeCifrado = new String(bytesMensajeCifrado);
			
			//System.out.println("Mensaje Original: " + mensajeOriginal);
			//System.out.println("Mensaje Cifrado: " + mensajeCifrado);
			
			//System.out.println("Desciframos el mensaje cifrado para comprobar que comprueba con el original");
			descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
			//System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
			
		} catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
	/*
	public String encriptador() {
		
		String clave = null;
		
		try {
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			SecretKey paloEspartano = generador.generateKey();
			System.out.println("Paso 2: Se ha obtenido la clave");

			Cipher descifrador = Cipher.getInstance("AES");
			System.out.println("Paso 3: Hemos obtenido el descifrador");
			
			descifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
			System.out.println("Paso 4: Hemos configurado el descifrador");
			
			
			Scanner sc1 = new Scanner(System.in);
			
			String mensajeOriginal = sc1;
			
			byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
			byte[] bytesMensajeCifrado = descifrador.doFinal(bytesMensajeOriginal);//cifrar el mensaje original
			String mensajeCifrado = new String(bytesMensajeCifrado);
			System.out.println("Mensaje Original: " + mensajeOriginal);
			System.out.println("Mensaje Cifrado: " + mensajeCifrado);
			
			System.out.println("Desciframos el mensaje cifrado para comprobar que comprueba con el original");
			descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
			System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
			
		} catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
		
		
		
		return null;
	}
	
	
	
	public String MostrarEncript() {
		
		String clave = null;
		
		return clave;
	}
	
	
	
	public String desencriptador() {
	
	String clave = null;
	
	return clave;
	}	
	*/
	
	

