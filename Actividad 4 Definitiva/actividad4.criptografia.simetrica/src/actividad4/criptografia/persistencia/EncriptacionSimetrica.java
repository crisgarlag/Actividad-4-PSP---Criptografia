package actividad4.criptografia.persistencia;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import actividad4.criptografiamo.modelo.Coche;

public class EncriptacionSimetrica {
	private KeyGenerator generador;
	private SecretKey claveSimetrica;
	private Cipher cifrador, descifrador;
	private List<byte[]> memoriaMensajeEncriptado;
	private List<SealedObject>memoriaCocheEncriptado;

	public EncriptacionSimetrica() {
		super();
		this.memoriaMensajeEncriptado = new ArrayList<byte[]>();
		this.memoriaCocheEncriptado = new ArrayList<SealedObject>();
	}
	
	public void inicializarVariables() {
		try {
			generador = KeyGenerator.getInstance("AES");
			claveSimetrica = generador.generateKey();
			cifrador = Cipher.getInstance("AES");
			cifrador.init(Cipher.ENCRYPT_MODE, claveSimetrica);
			descifrador = Cipher.getInstance("AES");
			descifrador.init(Cipher.DECRYPT_MODE, claveSimetrica);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void encriptarMensaje(String mensaje) {

		try {
			byte[] bMensajeOriginal = mensaje.getBytes();
			byte[] bMensajeEncriptado = cifrador.doFinal(bMensajeOriginal);
			System.out.println("El mensaje se ha encriptado");
			añadirMensajeEncriptado(bMensajeEncriptado);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarMensajeEncriptado() {
		
		String mensajeEncriptado = new String(obtenerMensajeEncriptado());
		System.out.println("El mensaje encriptado es: " + mensajeEncriptado);

	}

	public void desencriptarMensaje() {
		try {
			byte[] bMensajeDesencriptado = descifrador.doFinal(obtenerMensajeEncriptado());
			String mensajeDesencriptado = new String(bMensajeDesencriptado);
			System.out.println("La frase desencriptada es: " +  mensajeDesencriptado);
		} catch (GeneralSecurityException e) {
			
			e.printStackTrace();
		}
	}
	
	public void encriptarCoche(Coche coche) {
		
		try {
			SealedObject sealedObject = new SealedObject(coche, cifrador);
			memoriaCocheEncriptado.add(0,sealedObject);
			System.out.println("El coche se ha encriptado");
		} catch (IllegalBlockSizeException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	public void añadirMensajeEncriptado(byte[] bMensajeEncriptado) {

		memoriaMensajeEncriptado.add(0, bMensajeEncriptado);
	}

	public byte[] obtenerMensajeEncriptado() {

		byte[] bMensajeEncriptado = memoriaMensajeEncriptado.get(0);

		return bMensajeEncriptado;
	}

}
