
package ch.hearc.d_flux.a_data.file.b_text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class FileCsvs
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void save(double[][] tab, String filename, String separator) throws IOException
		{
		FileWriter fw = new FileWriter(filename);
		BufferedWriter bw = new BufferedWriter(fw);

		for(double[] line:tab)
			{
			for(double element:line)
				{
				bw.write(element + separator);
				}
			bw.newLine();
			}

		bw.close();
		fw.close();
		}

	public static double[][] load(String filename, String separator) throws IOException, NumberFormatException
		{
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		List<String> listLine = new LinkedList<String>();

		String line = br.readLine();
		while(line != null)
			{
			listLine.add(line);
			line = br.readLine();
			}

		br.close();
		fr.close();

		return toDoubleArray2D(listLine, separator);
		}

	public static double[][] clone(double[][] tabSource) throws IOException, NumberFormatException
		{
		String nameFile = "temp.csv";
		String separator = ";";

		save(tabSource, nameFile, separator);
		double[][] tabClone = load(nameFile, separator);

		Assertions.assertTrue(new File(nameFile).delete());

		return tabClone;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static double[][] toDoubleArray2D(List<String> listLine, String separator) throws NumberFormatException
		{
		double[][] tabDouble = new double[listLine.size()][];

		int i = 0;
		for(String line:listLine)
			{
			tabDouble[i++] = toDoubleArray1D(line, separator);
			}

		return tabDouble;
		}

	private static double[] toDoubleArray1D(String line, String separator) throws NumberFormatException
		{
		String[] tabString = line.split(separator);
		double[] tabDouble = new double[tabString.length];

		int i = 0;
		for(String string:tabString)
			{
			tabDouble[i++] = Double.parseDouble(string);
			}

		return tabDouble;
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final String EMPTY = "";

	}
