
package ch.hearc.d_flux.a_data.file.a_bin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.junit.jupiter.api.Assertions;

public class FileDoublesCryptage
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void save(double[] tab, String fileName) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException
		{
		Cipher cipher = Cipher.getInstance(NAME_ALGO);
		cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY);

		FileOutputStream fos = new FileOutputStream(fileName);
		BufferedOutputStream bos = new BufferedOutputStream(fos); // Speed-up * 10
		CipherOutputStream cos = new CipherOutputStream(bos, cipher);
		GZIPOutputStream gos = new GZIPOutputStream(cos);
		DataOutputStream dos = new DataOutputStream(gos);

		for(double value:tab)
			{
			dos.writeDouble(value);
			}

		dos.close();
		gos.close();
		cos.close();
		bos.close();
		fos.close();
		}

	public static double[] load(String fileName) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
		{
		Cipher cipher = Cipher.getInstance(NAME_ALGO);
		cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY);

		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis); // Speed-up * 10
		CipherInputStream cis = new CipherInputStream(bis, cipher);
		GZIPInputStream gis = new GZIPInputStream(cis);
		DataInputStream dis = new DataInputStream(gis);

		List<Double> list = new LinkedList<Double>();

		try
			{
			while(true)
				{
				double value = dis.readDouble();
				list.add(value);
				}
			}
		catch (IOException e)
			{
			// Fin du fichier
			}

		dis.close();
		gis.close();
		cis.close();
		bis.close();
		fis.close();

		return toArray(list);
		}

	public static double[] clone(double[] tab) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException
		{
		String fileName = "temp.bin";

		save(tab, fileName);
		double[] tabClone = load(fileName);

		Assertions.assertTrue(new File(fileName).delete());

		return tabClone;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static SecretKey createSecretKey()
		{
		try
			{
			return KeyGenerator.getInstance(NAME_ALGO).generateKey();
			}
		catch (NoSuchAlgorithmException e)
			{
			e.printStackTrace();
			return null;
			}
		}

	private static double[] toArray(List<Double> list)
		{
		double[] tab = new double[list.size()];
		int i = 0;
		for(double value:list)
			{
			tab[i++] = value;
			}

		return tab;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final SecretKey SECRET_KEY = createSecretKey();
	private static final String NAME_ALGO = "AES"; // Crypté sur 128bits

	}
