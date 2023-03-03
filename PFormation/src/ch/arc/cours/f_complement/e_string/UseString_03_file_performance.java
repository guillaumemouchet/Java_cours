
package ch.arc.cours.f_complement.e_string;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;

import ch.arc.tools.Chrono;

public class UseString_03_file_performance
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		System.out.println("flatmap string file performance: \n");

		useStringFile();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useStringFile()
		{
		try
			{
			String fileName = "./data/dataBig.csv";// separateur ;

			useCompterMotV1(fileName);

			System.out.println();

			useCompterMotV2(fileName);
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		}

	/**
	 * compter les mots
	 */
	private static void useCompterMotV1(String fileName) throws IOException
		{
		Chrono chrono = new Chrono();

		Stream<String> streamLines = Files.lines(Paths.get(fileName));

		useCompterMot(streamLines);

		streamLines.close();

		System.out.println(chrono);
		}

	/**
	 * compter les mots, best
	 */
	private static void useCompterMotV2(String fileName) //throws IOException
		{
		// v2.1
		//			{
		//			Chrono chrono = new Chrono();
		//
		//			Stream<String> streamLines = new BufferedReader(new FileReader(fileName)).lines(); // plus performant
		//
		//			useCompterMot(streamLines);
		//
		//			streamLines.close();
		//
		//			System.out.println(chrono);
		//			}

		// v2.2
			{
			Chrono chrono = new Chrono();

			try (Stream<String> streamLines = new BufferedReader(new FileReader(fileName)).lines();) // close automatiquement fait avec cette technique
				{
				useCompterMot(streamLines);

				System.out.println(chrono);
				}
			catch (FileNotFoundException e)
				{
				e.printStackTrace();
				}

			// il serait bien aussi d'utiliser cette technique du try catch dans la version v1,
			// et aussi dans le file training precedent
			}
		}

	/**
	 * compter les mots
	 */
	private static void useCompterMot(Stream<String> streamLines)
		{
		final String SEPARATEUR = ";";

		// reference methode si possible, sans variable
			{
			long count = streamLines//
					.map(l -> l.split(SEPARATEUR))//
					.flatMap(Arrays::stream)//
					.count();
			System.out.println("#mot=" + count);

			Assertions.assertTrue(count == 50000);
			}
		}

	}
