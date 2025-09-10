
package ch.hearc.d_flux.a_data.file.a_bin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.junit.jupiter.api.Assertions;

public class FileDoubles
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void save(double[] tab, String fileName) throws IOException
		{
		FileOutputStream fos = new FileOutputStream(fileName);
		BufferedOutputStream bos = new BufferedOutputStream(fos); // Speed-up * 10
		GZIPOutputStream gos = new GZIPOutputStream(bos);
		DataOutputStream dos = new DataOutputStream(gos);

		for(double value:tab)
			{
			dos.writeDouble(value);
			}

		dos.close();
		gos.close();
		bos.close();
		fos.close();
		}

	public static double[] load(String fileName) throws IOException
		{
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis); // Speed-up * 10
		GZIPInputStream gis = new GZIPInputStream(bis);
		DataInputStream dis = new DataInputStream(gis);

		List<Double> list = new LinkedList<Double>();

		try
			{
			while(true)
				{
				list.add(dis.readDouble());
				}
			}
		catch (IOException e)
			{
			// Fin du fichier
			}

		dis.close();
		gis.close();
		bis.close();
		fis.close();

		return toArray(list);
		}

	public static double[] clone(double[] tab) throws IOException
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

	}
