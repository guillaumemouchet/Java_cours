
package ch.arc.cours.f_complement.c_flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// flatMap
//
// 		But : Transformer une stream servant des tableaux, en une stream servant toutes les valeurs de tous les tableaux
//			  Marche pas seulement pour les tableaux, mais aussi pour :
//					- les list
//					- les set
//
//		Technique:	"Concatene" des stream dans une stream
//
//		Example:
//
//			{{1,11},{2,22},{3,33},{4,44,444}}  -> flatmap -> {1,11,2,22,3,33,4,44,444}
//
//			flatmap permet de degrouper et de mettre a la "queue leu leu"
//
// 		Examples:
//
//			Stream<int[]>			-> flatMap ->	IntStream
//
//			Stream<String[]>		-> flatMap ->	Stream<String>
//			Stream<Set<String>>		-> flatMap ->	Stream<String>
//			Stream<List<String>>	-> flatMap ->	Stream<String>
//			Stream<List<Object>>	-> flatMap ->	Stream<Object>
//
public class UseFlatMap_01_number
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
		System.out.println("flatmap number : \n");

		// number
			{
			defi();

			//			useArrayNumber();
			useListNumber1();
			useSetNumber2();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * flatmap sans flatmap
	 */
	private static void defi()
		{
		System.out.println("\n flatmap sans flatmap:\n");

		int[] v1 = { 1, 11, 111 };
		int[] v2 = { 2, 22, 222 };
		int[] v3 = { 3, 33, 333 };

		int[][] tabVectors = { v1, v2, v3 }; // un tableau 2D!

		// BUT :    Afficher sous cette forme tabVector
		//
		//			1
		//			11
		//			111
		//			2
		//			22
		//			222
		//			3
		//			33
		//			333
		//
		// Contrainte : Interdit d'utiliser un flatmap
		// Indication : Utiliser la methode concat static de Stream

		//Arrays.stream(tabVectors)// TODO
		//V1.1
			{
			Arrays//
					.stream(tabVectors)//Stream<int[]>
					.map(v -> Arrays.stream(v))//Stream<IntStream>
					.reduce((s1, s2) -> IntStream.concat(s1, s2))//Optional<IntStream>
					.get()//IntStream
					.forEach(System.out::println);
			}
		//V1.2
			{
			Arrays//
					.stream(tabVectors)//Stream<int[]>
					.map(Arrays::stream)//Stream<IntStream>
					.reduce(IntStream::concat)//Optional<IntStream>
					.get()//IntStream
					.forEach(System.out::println);
			}
		//V2
			{
			Arrays//
					.stream(tabVectors)//Stream<int[]>
					.map(Arrays::stream)//Stream<IntStream>
					.reduce(IntStream.empty(), IntStream::concat)//IntStream
					.forEach(System.out::println);
			}
		//V3
			{
			Arrays//
					.stream(tabVectors)//Stream<int[]>
					.flatMapToInt(Arrays::stream)//IntStream
					.forEach(System.out::println);
			}
		}

	/**
	 * mettre chaque nombre dans un unique tableau 1d
	 */
	private static void useListNumber1()
		{
		System.out.println("\nuseListNumber1:\n");

		List<Double> g1 = List.of(1d, 11d, 111d);// g comme groupe
		List<Double> g2 = List.of(2d, 22d, 222d);
		List<Double> g3 = List.of(3d, 33d, 333d);

		List<List<Double>> listGroupes = List.of(g1, g2, g3);

		// lambda dans variable
			{
			// Warning : deuxieme template est une Stream<Double> et non une DoubleStream
			Function<List<Double>, Stream<Double>> giToStreamDouble = g -> g.stream();

			Double[] tab = listGroupes//
					.stream()//Stream<List<Double>>
					.flatMap(giToStreamDouble)//Stream<Double>
					.toArray(Double[]::new);//Double[]

			System.out.println(Arrays.toString(tab));
			}

		// reference methode sans variable
			{
			double[] tab = listGroupes//
					.stream()//Stream<List<Double>>
					.flatMap(List::stream)//Stream<Double>
					.mapToDouble(Double::doubleValue)//DoubleStream
					.toArray();//double[]

			System.out.println(Arrays.toString(tab));
			}

		}

	/**
	 * somme des nombres
	 */
	private static void useSetNumber2()
		{
		System.out.println("\nuseSetNumber2:\n");

		Set<Double> g1 = Set.of(1d, 11d, 111d);
		Set<Double> g2 = Set.of(2d, 22d, 222d);
		Set<Double> g3 = Set.of(3d, 33d, 333d);

		// avec flatMap
			{
			Stream<Set<Double>> streamGroupes = Stream.of(g1, g2, g3);

			double sum = streamGroupes//Stream<Set<Double>>
					.flatMap(Set::stream)//Stream<Stream<Double>>
					.mapToDouble(Double::doubleValue)//DoubleStream
					.sum();//double

			System.out.println("sum=" + sum);
			}

		// avec flatMapToDouble
			{
			Stream<Set<Double>> streamGroupes = Stream.of(g1, g2, g3);// again, car stream usage unique

			// Warning : deuxieme template est un DoubleStream et non une Stream<Double> comme ci-dessus
			Function<Set<Double>, DoubleStream> giToDoubleStream = s -> s//
					.stream()//Stream<Double>
					.mapToDouble(Double::doubleValue);//DoubleStream

			// Indication: flatMapToDouble
			double sum = streamGroupes//Stream<Set<Double>>
					.flatMapToDouble(giToDoubleStream)//DoubleStream
					.sum();//double

			System.out.println("sum=" + sum);
			}
		}
	}
