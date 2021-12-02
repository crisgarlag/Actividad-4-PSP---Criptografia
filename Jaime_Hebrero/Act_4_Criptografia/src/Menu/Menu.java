package Menu;

import java.security.GeneralSecurityException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Menu {

	public static void main(String[] args) {
		
		
		
		
	
		
	       boolean salir = false;
	       int opcion; //Guardaremos la opcion del usuario
	        
	       while(!salir){
	            
	    	   System.out.println("---------MENU ---------\n");
	   		System.out.println("Seleecione una opcion.");
	   		System.out.println("1.- Salir del programa.");
	   		System.out.println("2.- Encriptar frase.");
	   		System.out.println("3.- Mostrar frase encritada");
	   		System.out.println("4.- Desencriptar frase");
	            
	   		Scanner sn = new Scanner(System.in);
	   		opcion = sn.nextInt(); 
	   		
              System.out.println("Escribe la frase a encritar");
               Scanner sc = new Scanner(System.in);
               String mensajeOriginal = sc.nextLine();
 
                
                try {
        			KeyGenerator generador = KeyGenerator.getInstance("AES");
        			//("Paso 1: Se ha obtenido el generador de claves");
        			
        			SecretKey paloEspartano = generador.generateKey();
        			//("Paso 2: Se ha obtenido la clave");

        			Cipher descifrador = Cipher.getInstance("AES");
        			//("Paso 3: Hemos obtenido el descifrador");
        			
        			descifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
        			//("Paso 4: Hemos configurado el descifrador");
        			
        			
        			
        			
        			byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
        			byte[] bytesMensajeCifrado = descifrador.doFinal(bytesMensajeOriginal);//cifrar el mensaje original
        			String mensajeCifrado = new String(bytesMensajeCifrado);
        			
        			//("Desciframos el mensaje cifrado para comprobar que comprueba con el original");
        			descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
        			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
        			
        			
        			try {switch (opcion) {
	                    case 1:
	                        
	                        salir= true;
	                        break;
	                        
	                        //--------------------------------------------------------------------------------------------------------------------
	                        
	                    case 2:
	                        System.out.println("Encriptar frase");
	                        
	                		
	                        System.out.println("Mensaje Original: " + mensajeOriginal);
	                			
	                        break;
	                        
	                        //--------------------------------------------------------------------------------------------------------------------
	
	                    case 3:
	                    	System.out.println("Mensaje Cifrado: " + mensajeCifrado);
	                        break;
	                        
	                        //--------------------------------------------------------------------------------------------------------------------
	
	                    case 4:
	                    	System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
	                    	
	                        break;
	                    default:
	                        System.out.println("Solo números entre 1 y 4");
        			}
        			
        			} catch (InputMismatchException e) {
        				System.out.println("Debes insertar un número");
        				sn.next();
        			}
        			
        			
        			
        			
        		} catch (GeneralSecurityException gse) {
        			System.out.println("Algo ha fallado.." + gse.getMessage());
        			gse.printStackTrace();
        		}
    			
                
              
                
                
	   		
	            
	       }
		
	
	       
	       
	      
	}

}
