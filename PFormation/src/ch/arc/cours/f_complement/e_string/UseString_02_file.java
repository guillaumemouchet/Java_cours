
package ch.arc.cours.f_complement.e_string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class UseString_02_file
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
		System.out.println("flatmap string file: \n");

		useStringFile();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useStringFile()
		{
		try
			{
			String fileName = "./data/data.txt";

			useAfficherLine(fileName);
			useAfficherMot(fileName);
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		}

	/**
	 * Afficher les lignes
	 */
	private static void useAfficherLine(String fileName) throws IOException
		{
		Stream<String> streamLines = Files.lines(Paths.get(fileName));

		streamLines.forEach(System.out::println);

		streamLines.close();

		System.out.println();
		}

	/**
	 * afficher les mots, un sur chaque line
	 */
	private static void useAfficherMot(String fileName) throws IOException
		{
		final String ESPACE = " ";

		// lambda
			{
			Stream<String> streamLines = Files.lines(Paths.get(fileName));

			// Indications:
			//		(I1) line ----> String[]
			//		(I2) split(ESPACE) de String renvoie un tableau
			Function<String, String[]> lineToStringArray = l -> l.split(ESPACE);

			Function<String[], Stream<String>> toStreamString = Arrays::stream;

			streamLines//
					.map(lineToStringArray)//ligne -> tab mots
					.flatMap(toStreamString)// tab mots -> mots (degrouper)
					.forEach(System.out::println);

			streamLines.close();

			System.out.println();
			}

		// reference methode si possible, sans variable, one line
			{
			Stream<String> streamLines = Files.lines(Paths.get(fileName));

			streamLines//
					.map(l -> l.split(ESPACE))//
					.flatMap(Arrays::stream)//
					.forEach(System.out::println);

			streamLines.close();

			System.out.println();
			}
		}
	}
