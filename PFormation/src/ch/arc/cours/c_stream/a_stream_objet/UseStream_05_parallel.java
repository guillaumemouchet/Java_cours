
package ch.arc.cours.c_stream.a_stream_objet;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import ch.arc.cours.z_annexe.material.Personne;
import ch.arc.cours.z_annexe.material.PersonneTools;
import ch.arc.tools.stream.Streams;

public class UseStream_05_parallel
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
		int n = 5;

		System.out.println("stream : parallel");

		list(n);
		arrayInteger();
		arrayInt();
		iterable(n);

		norme();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				List			*|
	\*------------------------------*/

	/**
	 * Probleme :	 somme des hauteur des personnes dont age > 50
	 *
	 * Contraintes : stream parallel
	 */
	private static void list(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		System.out.println(list);

		int sumHauteur = list//
				.parallelStream()//
				.filter(p -> p.getAge() > 50)//
				//.mapToInt( p-> p.getHauteur()) // TODO
				.mapToInt(Personne::getHauteur)//
				.sum();

		System.out.println("sumHauteur avec age >50  : " + sumHauteur);
		}

	/*------------------------------*\
	|*				Array			*|
	\*------------------------------*/

	/**
	 * Probleme :	  somme n premiers entiers
	 *
	 * Contraintes :  stream parallel
	 */
	private static void arrayInteger()
		{
		final int n = 9;
		Integer[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // sommer les elements de ce tableau

		// Rappel : Arrays.stream(tab) est une Stream<Integer>
		int sum = Arrays//
				.stream(tab)//
				.parallel()//
				.mapToInt(i -> i)//
				.sum();//TODO

		Assert.assertTrue(sum == n * (n + 1) / 2);
		}

	/**
	 * Idem ci-dessus, mais en int
	 */
	private static void arrayInt()
		{
		final int n = 9;
		int[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// Rappel : Arrays.stream(tab) est une intStream !
		int sum = Arrays//
				.stream(tab)//
				.parallel()//
				.sum();//TODO

		Assert.assertTrue(sum == n * (n + 1) / 2);
		}

	/*------------------------------*\
	|*				Iterable		*|
	\*------------------------------*/

	/**
	 * Probleme :	 somme des hauteur des personnes dont age > 50
	 *
	 * Contraintes : stream parallel
	 */
	private static void iterable(int n)
		{
		Iterable<Personne> iterable = PersonneTools.create(n);

		// Indications : Streams
		int sumHauteur = Streams//
				.parallelStream(iterable)//
				.filter(p -> p.getAge() > 50)//
				.mapToInt(Personne::getHauteur)//
				.sum();// TODO

		System.out.println("sumHauteur avec age >50  : " + sumHauteur);
		}

	/*------------------------------*\
	|*				Defi 			*|
	\*------------------------------*/

	/**
	 * <pre>
	 * Probleme :	 Norme d'un vecteur
	 *
	 * Contraintes : en parallel
	 *
	 * Rappel:		||v||= sqrt(v1*v1+v2*v2+...+vn*vn)
	 * 				abev v=(v1,v2,...vn)
	 * </pre>
	 */
	private static void norme()
		{
		int[] v = { 9, 3, 5, 2, 5, 6, 7, 1, 4, 8 };

		double norme = Math.sqrt(Arrays//
				.stream(v)//
				.parallel()//
				.mapToLong(vi -> vi * vi).sum());// TODO

		Assertions.assertEquals(norme, 17.60681686165901);
		}

	}
