
package ch.arc.cours.a_lamda.b_neu_interfacefonctionelle.d_function;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import ch.arc.cours.z_annexe.material.Maison;



public class MaisonManipulator
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * see chapter stream to see beautiful flexible optimized code
	 */
	public static void mapPrint(Iterable<Maison> iterable, Function<Maison, Integer> function)
		{
		for(Maison maison:iterable)
			{
			int attribut = function.apply(maison);

			System.out.println(attribut);
			}
		}

	/**
	 * see chapter stream to see beautiful flexible optimized code
	 */
	public static void mapPrintInt(Iterable<Maison> iterable, ToIntFunction<Maison> function)
		{
		for(Maison maison:iterable)
			{
			int attribut = function.applyAsInt(maison);

			System.out.println(attribut);
			}
		}

	/**
	 * see chapter stream to see beautiful flexible optimized code
	 */
	public static int mapReduce(Iterable<Maison> iterable, ToIntFunction<Maison> function, IntBinaryOperator operator, int initValue) // sans wrapper
		{
		int value = initValue;

		for(Maison maison:iterable)
			{
			int attribut = function.applyAsInt(maison);
			value = operator.applyAsInt(value, attribut);
			}

		return value;
		}

	/**
	 * see chapter stream to see beautiful flexible optimized code
	 */
	public static int filterMapReduce(Iterable<Maison> iterable, Predicate<Maison> predicate, ToIntFunction<Maison> function, IntBinaryOperator operator, int initValue)  // sans wrapper
		{
		int value = initValue;

		for(Maison maison:iterable)
			{
			if(predicate.test(maison))
				{
				int attribut = function.applyAsInt(maison);
				value = operator.applyAsInt(value, attribut);
				}
			}

		return value;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
