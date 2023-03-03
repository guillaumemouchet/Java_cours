
package ch.arc.cours.f_complement.h_grouping.c_collect_groupingBy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ch.arc.cours.z_annexe.tools.CollectionTools;

public class UseCollectors_groupingBy_03_defi_thread
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
		System.out.println("collectors : groupingBy : defi 1 : thread");

		thread();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * <pre>
	 * Contexte :	On s'interesse au nombre de thread dans une stream parallel de type IntStream.range(0.n)
	 * 				On aimerait savoir quel thread s'occupe de travailler quel indice
	 *
	 * Output : 	Une map avec
	 * 					key = nameThread
	 * 					value = list des indices travailler par le thread
	 * </pre>
	 */
	private static void thread()
		{
		int n = Runtime.getRuntime().availableProcessors() * 10;

		int sum = IntStream//
				.range(0, n)//
				.parallel()//
				.mapToObj(i -> Thread.currentThread().getName())//
				.collect(Collectors.toSet())// terminal
				.size();
		System.out.println(sum);

		// functionClassifier:
		//		(I1) Thread.currentThread().getName()
		Function<Integer, String> nameThread = i -> Thread.currentThread().getName();

		// valueCollector:
		//		(I1) boxed     :  IntStream       to   Stream<Integer>
		//		(I2) mapToInt  :  Stream<Integer> to   IntStream
		//		(I3) collect existe only sur Stream<Object>
		//		(I4) Utiliser le default valueCollector
		Map<String, List<Integer>> mapNameIndice = IntStream//
				.range(0, n)//
				.parallel()//
				//.mapToObj(Integer::new)
				//.mapToObj(i->i)
				.boxed()//
				.collect(Collectors.groupingBy(nameThread)); //to list par défaut

		System.out.println(mapNameIndice.size());

		CollectionTools.print("[groupingBy nameThread]", mapNameIndice);
		System.out.println("#processor =" + Runtime.getRuntime().availableProcessors());
		}

	}
