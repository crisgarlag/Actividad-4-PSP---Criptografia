package actividad4.criptografia.persistencia;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SealedObject;

import actividad4.criptografiamo.modelo.Coche;

public class EncriptacionAsimetrica {
	private KeyPairGenerator generador;
	private KeyPair claves;
	private Cipher cifrador, descifrador;
	private List<byte[]> memoriaMensajeEncriptado;
	private List<SealedObject> memoriaCocheEncriptado;

	public EncriptacionAsimetrica() {
		super();
		this.memoriaMensajeEncriptado = new ArrayList<byte[]>();
		this.memoriaCocheEncriptado = new ArrayList<SealedObject>();
	}

	public void inicializarVariables() {
		try {
			generador = KeyPairGenerator.getInstance("RSA");
			claves = generador.generateKeyPair();
			cifrador = Cipher.getInstance("RSA");
			cifrador.init(Cipher.ENCRYPT_MODE, claves.getPublic());
			descifrador = Cipher.getInstance("RSA");
			descifrador.init(Cipher.DECRYPT_MODE, claves.getPrivate());
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void encriptarMensaje(String mensaje) {

		try {
			byte[] bMensajeOriginal = mensaje.getBytes();
			byte[] bMensajeEncriptado = cifrador.doFinal(bMensajeOriginal);
			System.out.println("El mensaje se ha encriptado con clave publica");
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
			System.out.println("La frase desencriptada con clave privada es: " + mensajeDesencriptado);
		} catch (GeneralSecurityException e) {

			e.printStackTrace();
		}
	}

	public void encriptarCoche(Coche coche) {

		try {
			SealedObject sealedObject = new SealedObject(coche, cifrador);
			
			memoriaCocheEncriptado.add(0,sealedObject);
			System.out.println("El coche se ha encriptado con clave pública");
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
