
package ch.arc.cours.f_complement.d_peek;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.JButton;

public class Use_peek
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
		System.out.println("peek");

		useSwing();
		useFlatMap();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * <pre>
	 * But:
	 *
	 * 			EX1
	 * 					Creer n boutons, avec comme texte "b0" "b1" "b2" ....
	 *					Les stocker dans un tableaux
	 *
	 * 			EX2
	 *
	 * 					Attacher un listener (click) a ces boutons, qui affiche l'event
	 *
	 * 			EX3
	 * 					Faire EX1 et EX2 en une seule stream
	 *
	 * Contrainte:
	 *
	 * 			(C1) References methode si possible
	 *
	 * 			(C2) Le moins de variable possible
	 *
	 * 			(C3) En parallel
	 *
	 * 			(C4) Presentation du code: casser votre stream sur plusieurs lignes
	 *
	 * </pre>
	 */
	private static void useSwing()
		{
		int n = 10;
		final String PREFIXE = "b";
		final String ESPACE = " ";

		// EX1 : créer les boutons
		//
		// Contraintes:
		//		(C1) Utiliser 2 "map"
		//
		JButton[] tabBoutons = IntStream//
				.range(0, n)//
				.mapToObj(i -> PREFIXE + i)//Stream<String>
				.map(JButton::new)//Stream<JButton>
				.toArray(JButton[]::new);

		//EX2 : attacher listener qui affiche l'event
			{
			Arrays//
					.stream(tabBoutons)//Stream<JButton>
					.forEach(b -> b.addActionListener(e -> System.out.println(e)));
			}

		//EX3 : EX1 et EX2 avec une seule stream
			{
			// Indication : peek comme foreach mais non terminal

			IntStream//
					.range(0, n)//
					.mapToObj(i -> PREFIXE + i)//Stream<String>
					.map(JButton::new)//Stream<JButton>
					.peek(b -> b.addActionListener(System.out::println))//Stream<JButton>
					.toArray(JButton[]::new);
			}
		}

	/**
	 * Mettre dans un unique tableau les nombres des 3 vecteurs, puis afficher ce tableau
	 */
	private static void useFlatMap()
		{
		Integer[] v1 = { 1 };
		Integer[] v2 = { 10, 20 };
		Integer[] v3 = { 100, 200, 300 };

		List<Integer[]> listVector = List.of(v1, v2, v3);

		// Contraintes : afficher dans la stream les vecteurs vi qui descendent
		Integer[] tabFlat = listVector//
				.stream()//Stream<Integer[]>
				.peek(v -> System.out.println(Arrays.toString(v)))//Stream<Integer[]>
				.flatMap(Arrays::stream)//Stream<Integer>
				.peek(System.out::println)//Stream<Integer>
				.toArray(Integer[]::new);
		}

	}
